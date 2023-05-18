package com.obeast.admin.biz.controller;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.obeast.admin.api.entity.SysMenu;
import com.obeast.admin.biz.service.SysMenuService;
import com.obeast.admin.biz.service.SysRoleMenuService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.log.annotation.SysLogFlag;
import com.obeast.common.security.util.SecurityUtils;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wxl
 * Date 2023/4/10 0:16
 * @version 1.0
 * Description: 菜单管理模块
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
@Tag(name = "菜单管理模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class SysMenuController {

	private final SysMenuService sysMenuService;

	private final SysRoleMenuService sysRoleMenuService;


	@GetMapping("/infos")
	public CommonResult<List<Tree<Long>>> getUserMenuInfos(Long parentId) {
		// 获取符合条件的菜单
		Set<SysMenu> menuSet = SecurityUtils.getRoles()
				.stream()
				.map(sysMenuService::findMenuByRoleId)
				.flatMap(Collection::stream)
				.collect(Collectors.toSet());
		return CommonResult.success(sysMenuService.filterMenuInfos(menuSet, parentId));
	}

	/**
	 * 返回树形菜单集合
	 * @param lazy 是否是懒加载
	 * @param parentId 父节点ID
	 * @return 树形菜单
	 */
	@GetMapping(value = "/tree")
	public CommonResult<List<Tree<Long>>> getTree(
			boolean lazy,
			Long parentId,
			@RequestParam(value = "menuName", required = false) String menuName
	) {
		return CommonResult.success(sysMenuService.treeMenu(lazy, parentId, menuName));
	}

	/**
	 * 返回角色的菜单关系集合
	 * @param roleId 角色ID
	 * @return 属性集合
	 */
	@GetMapping("/rels/{roleId}")
	public CommonResult<Object> getMenuIdList(@PathVariable Long roleId) {
		return CommonResult.success(sysRoleMenuService.getMenuIdsByRoleId(roleId));
//		return CommonResult.success(sysMenuService.findMenuByRoleId(roleId));
	}

	/**
	 * 通过ID查询菜单的详细信息
	 * @param id 菜单ID
	 * @return 菜单详细信息
	 */
	@GetMapping("/{id:\\d+}")
	public CommonResult<SysMenu> getById(@PathVariable Long id) {
		return CommonResult.success(sysMenuService.getById(id));
	}

	/**
	 * 新增菜单
	 * @param sysMenu 菜单信息
	 * @return 含ID 菜单信息
	 */
	@SysLogFlag("新增菜单")
	@PostMapping("/add")
	@PreAuthorize("@pms.hasPermission('sys_menu_add')")
	public CommonResult<SysMenu> save(@Valid @RequestBody SysMenu sysMenu) {
		sysMenuService.save(sysMenu);
		return CommonResult.success(sysMenu);
	}

	/**
	 * 删除菜单
	 * @param id 菜单ID
	 * @return success/false
	 */
	@SysLogFlag("删除菜单")
	@DeleteMapping("/{id:\\d+}")
	@PreAuthorize("@pms.hasPermission('sys_menu_del')")
	public CommonResult<Boolean> removeById(@PathVariable Long id) {
		return CommonResult.success(sysMenuService.removeMenuById(id));
	}

	/**
	 * 更新菜单
	 * @param sysMenu sysMenu
	 */
	@SysLogFlag("更新菜单")
	@PutMapping("/update")
	@PreAuthorize("@pms.hasPermission('sys_menu_edit')")
	public CommonResult<Boolean> update(@Valid @RequestBody SysMenu sysMenu) {
		return CommonResult.success(sysMenuService.updateMenuById(sysMenu));
	}

	/**
	 * 清除菜单缓存
	 */
	@SysLogFlag("清除菜单缓存")
	@DeleteMapping("/cache")
	@PreAuthorize("@pms.hasPermission('sys_menu_del')")
	public CommonResult<?> clearMenuCache() {
		sysMenuService.clearMenuCache();
		return CommonResult.success();
	}

}
