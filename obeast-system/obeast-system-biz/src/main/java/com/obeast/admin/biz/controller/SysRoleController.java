
package com.obeast.admin.biz.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.admin.api.entity.SysRole;
import com.obeast.admin.api.vo.RoleVo;
import com.obeast.admin.biz.service.SysRoleMenuService;
import com.obeast.admin.biz.service.SysRoleService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.log.annotation.SysLogFlag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author wxl
 * Date 2023/4/10 0:17
 * @version 1.0
 * Description: 角色管理模块
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Tag(name = "角色管理模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class SysRoleController {

	private final SysRoleService sysRoleService;

	private final SysRoleMenuService sysRoleMenuService;

	/**
	 * 通过ID查询角色信息
	 * @param id ID
	 * @return 角色信息
	 */
	@GetMapping("/{id:\\d+}")
	public CommonResult<SysRole> getById(@PathVariable Long id) {
		return CommonResult.success(sysRoleService.getById(id));
	}

	/**
	 * 添加角色
	 * @param sysRole 角色信息
	 * @return success、false
	 */
	@SysLogFlag("添加角色")
	@PostMapping("/add")
	@PreAuthorize("@pms.hasPermission('sys_role_add')")
	public CommonResult<Boolean> save(@Valid @RequestBody SysRole sysRole) {
		return CommonResult.success(sysRoleService.save(sysRole));
	}

	/**
	 * 修改角色
	 * @param sysRole 角色信息
	 * @return success/false
	 */
	@SysLogFlag("修改角色")
	@PutMapping("/update")
	@PreAuthorize("@pms.hasPermission('sys_role_edit')")
	public CommonResult<Boolean> update(@Valid @RequestBody SysRole sysRole) {
		return CommonResult.success(sysRoleService.updateById(sysRole));
	}

	/**
	 * 删除角色
	 * @param id id
	 */
	@SysLogFlag("删除角色")
	@DeleteMapping("/{id:\\d+}")
	@PreAuthorize("@pms.hasPermission('sys_role_del')")
	public CommonResult<Boolean> removeById(@PathVariable Long id) {
		return CommonResult.success(sysRoleService.removeRoleById(id));
	}

	/**
	 * 获取角色列表
	 * @return 角色列表
	 */
	@GetMapping("/list")
	public CommonResult<List<SysRole>> listRoles() {
		return CommonResult.success(sysRoleService.list(Wrappers.emptyWrapper()));
	}

	/**
	 * 分页查询角色信息
	 * @param page 分页对象
	 * @return 分页对象
	 */
	@GetMapping("/page")
	public CommonResult<IPage<SysRole>> getRolePage(Page<SysRole> page, @RequestParam(value = "roleName", required = false) String roleName) {
		LambdaQueryWrapper<SysRole> lambdaQuery = Wrappers.lambdaQuery();
		if (StrUtil.isNotBlank(roleName)){
			lambdaQuery.eq(SysRole::getRoleName, roleName);
		}
		return CommonResult.success(sysRoleService.page(page, lambdaQuery));
	}

	/**
	 * 更新角色菜单
	 * @param roleVo 角色对象
	 * @return success、false
	 */
	@SysLogFlag("更新角色菜单")
	@PutMapping("/rels/update")
	@PreAuthorize("@pms.hasPermission('sys_role_perm')")
	public CommonResult<Boolean> saveRoleMenus(@RequestBody RoleVo roleVo) {
		return CommonResult.success(sysRoleMenuService.saveRoleMenus(roleVo.getRoleId(), roleVo.getMenuIds()));
	}


}
