package com.obeast.admin.biz.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.admin.api.entity.SysMenu;
import com.obeast.admin.api.entity.SysRoleMenu;
import com.obeast.admin.biz.mapper.SysMenuMapper;
import com.obeast.admin.biz.mapper.SysRoleMenuMapper;
import com.obeast.admin.biz.service.SysMenuService;
import com.obeast.common.core.constant.CacheConstants;
import com.obeast.common.core.constant.CommonConstants;
import com.obeast.common.core.constant.enums.MenuTypeEnum;
import com.obeast.common.core.exception.ErrorCodes;
import com.obeast.common.core.utils.MsgUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wxl
 * Date 2023/4/10 0:21
 * @version 1.0
 * Description: 菜单权限表 服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

	private final SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	@Cacheable(value = CacheConstants.MENU_DETAILS, key = "#roleId  + '_menu'", unless = "#result == null")
	public Set<SysMenu> findMenuByRoleId(Long roleId) {
		return baseMapper.listMenusByRoleId(roleId);
	}

	/**
	 * 级联删除菜单
	 * @param id 菜单ID
	 * @return true成功, false失败
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	@CacheEvict(value = CacheConstants.MENU_DETAILS, allEntries = true)
	public Boolean removeMenuById(Long id) {
		// 查询父节点为当前节点的节点
		List<SysMenu> menuList = this.list(Wrappers.<SysMenu>query().lambda().eq(SysMenu::getParentId, id));

		Assert.isTrue(CollUtil.isEmpty(menuList), MsgUtil.getMessage(ErrorCodes.SYS_MENU_DELETE_EXISTING));

		sysRoleMenuMapper.delete(Wrappers.<SysRoleMenu>query().lambda().eq(SysRoleMenu::getMenuId, id));
		// 删除当前菜单及其子菜单
		return this.removeById(id);
	}

	@Override
//	@CacheEvict(value = CacheConstants.MENU_DETAILS, allEntries = true)
	public Boolean updateMenuById(SysMenu sysMenu) {
		return this.updateById(sysMenu);
	}

	/**
	 * 构建树查询 1. 不是懒加载情况，查询全部 2. 是懒加载，根据parentId 查询 2.1 父节点为空，则查询ID -1
	 * @param lazy 是否是懒加载
	 * @param parentId 父节点ID
	 * @return List<Tree<Long>>
	 */
	@Override
	public List<Tree<Long>> treeMenu(boolean lazy, Long parentId, String menuName) {
		Long parent = parentId == null ? CommonConstants.MENU_TREE_ROOT_ID : parentId;
		LambdaQueryWrapper<SysMenu> queryWrapper = Wrappers.lambdaQuery();
		if (lazy) {
			queryWrapper.eq(SysMenu::getParentId, parent);
		}
		if (StrUtil.isNotBlank(menuName)) {
			queryWrapper.like(SysMenu::getName, menuName);
		}
		queryWrapper.orderByAsc(SysMenu::getSortOrder);
		List<TreeNode<Long>> collect = baseMapper
				.selectList(queryWrapper)
				.stream()
				.map(getNodeFunction())
				.collect(Collectors.toList());
		return TreeUtil.build(collect, parent);
	}

	@Override
	public List<Tree<Long>> filterMenu(Set<SysMenu> all, Long parentId) {
		List<TreeNode<Long>> collect = all.stream()
			.filter(menu -> MenuTypeEnum.LEFT_MENU.getType().equals(menu.getType()))
			.filter(menu -> StrUtil.isNotBlank(menu.getPath()))
			.map(getNodeFunction())
			.collect(Collectors.toList());
		Long parent = parentId == null ? CommonConstants.MENU_TREE_ROOT_ID : parentId;
		return TreeUtil.build(collect, parent);
	}
	@Override
	public List<Tree<Long>> filterMenuInfos(Set<SysMenu> all, Long parentId) {
		List<TreeNode<Long>> collect = all.stream()
				.filter(menu -> MenuTypeEnum.LEFT_MENU.getType().equals(menu.getType()))
				.filter(menu -> StrUtil.isNotBlank(menu.getPath()))
				.map(customNode())
				.collect(Collectors.toList());
		Long parent = parentId == null ? CommonConstants.MENU_TREE_ROOT_ID : parentId;
		return TreeUtil.build(collect, parent);
	}

	@Override
	@CacheEvict(value = CacheConstants.MENU_DETAILS, allEntries = true)
	public void clearMenuCache() {

	}

	@NotNull
	private Function<SysMenu, TreeNode<Long>> getNodeFunction() {
		return menu -> {
			TreeNode<Long> node = new TreeNode<>();
			node.setId(menu.getMenuId());
			node.setName(menu.getName());
			node.setParentId(menu.getParentId());
			node.setWeight(menu.getSortOrder());
			// 扩展属性
			Map<String, Object> extra = new HashMap<>();
			extra.put("icon", menu.getIcon());
			extra.put("path", menu.getPath());
			extra.put("type", menu.getType());
			extra.put("permission", menu.getPermission());
			extra.put("label", menu.getName());
			extra.put("sortOrder", menu.getSortOrder());
			extra.put("keepAlive", menu.getKeepAlive());
			extra.put("delFlag", menu.getDelFlag());
			extra.put("menuId", menu.getMenuId());
			node.setExtra(extra);
			return node;
		};
	}

	@NotNull
	private Function<SysMenu, TreeNode<Long>> customNode() {
		return menu -> {
			TreeNode<Long> node = new TreeNode<>();
			node.setId(menu.getMenuId());
			node.setName(menu.getName());
			node.setParentId(menu.getParentId());
			node.setWeight(menu.getSortOrder());
			Map<String, Object> meta = new HashMap<>();
			meta.put("icon",menu.getIcon());
			meta.put("title",menu.getName());
			meta.put("isLink", "");
			meta.put("isHide", !menu.getDelFlag().equals("0"));
			meta.put("isFull", menu.getIsFull().equals("0"));
			meta.put("isAffix", menu.getIsAffix().equals("0"));
			meta.put("isKeepAlive", menu.getKeepAlive().equals("0"));
			// 扩展属性
			Map<String, Object> extra = new HashMap<>();
			if (menu.getPath().split("/")[1].contains("home")){
				meta.put("isAffix", true);
				extra.put("component", menu.getPath() + "/index");
			}
			if (!menu.getParentId().equals(CommonConstants.MENU_TREE_ROOT_ID) || menu.getPath().split("/")[1].contains("home")) {
				extra.put("component", menu.getPath() + "/index");
			}
			extra.put("meta", meta);
			extra.put("path", menu.getPath());
			extra.put("name", menu.getPath());
			node.setExtra(extra);
			return node;
		};
	}

}
