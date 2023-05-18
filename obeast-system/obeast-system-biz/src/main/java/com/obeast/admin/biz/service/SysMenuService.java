package com.obeast.admin.biz.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysMenu;

import java.util.List;
import java.util.Set;

/**
 * @author wxl
 * Date 2023/4/10 0:23
 * @version 1.0
 * Description: 菜单权限表 服务类
 */
public interface SysMenuService extends IService<SysMenu> {

	/**
	 * 通过角色编号查询URL 权限
	 * @param roleId 角色ID
	 * @return 菜单列表
	 */
	Set<SysMenu> findMenuByRoleId(Long roleId);

	/**
	 * 级联删除菜单
	 * @param id 菜单ID
	 * @return true成功, false失败
	 */
	Boolean removeMenuById(Long id);

	/**
	 * 更新菜单信息
	 * @param sysMenu 菜单信息
	 * @return 成功、失败
	 */
	Boolean updateMenuById(SysMenu sysMenu);

	/**
	 * 构建树
	 * @param lazy 是否是懒加载
	 * @param parentId 父节点ID
	 * @param menuName 菜单名
	 * @return List<Tree<Long>>
	 */
	List<Tree<Long>> treeMenu(boolean lazy, Long parentId, String menuName);

	/**
	 * 查询菜单
	 * @param menuSet menuSet
	 * @param parentId parentId
	 * @return List<Tree<Long>>
	 */
	List<Tree<Long>> filterMenu(Set<SysMenu> menuSet, Long parentId);

	List<Tree<Long>> filterMenuInfos(Set<SysMenu> all, Long parentId);

	/**
	 * 清除菜单缓存
	 */
	void clearMenuCache();

	default void menuConvert(){

	}

}
