package com.obeast.admin.biz.controller;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.admin.api.entity.SysRole;
import com.obeast.admin.biz.service.SysDeptService;
import com.obeast.admin.api.entity.SysDept;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.log.annotation.SysLogFlag;
import com.obeast.common.security.annotation.Inner;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:15
 * @version 1.0
 * Description: 部门管理 前端控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/dept")
@Tag(name = "部门管理模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class SysDeptController {

	private final SysDeptService sysDeptService;

	/**
	 * 通过ID查询
	 * @param id ID
	 * @return SysDept
	 */
	@GetMapping("/{id:\\d+}")
	public CommonResult<SysDept> getById(@PathVariable Long id) {
		return CommonResult.success(sysDeptService.getById(id));
	}

	/**
	 * 返回树形菜单集合
	 * @return 树形菜单
	 */
	@GetMapping(value = "/tree")
	public CommonResult<List<Tree<Long>>> listDeptTrees(@RequestParam(value = "deptName", required = false) String deptName) {
		return CommonResult.success(sysDeptService.listDeptTrees(deptName));
	}

	/**
	 * 返回当前用户树形菜单集合
	 * @return 树形菜单
	 */
	@GetMapping(value = "/user-tree")
	public CommonResult<List<Tree<Long>>> listCurrentUserDeptTrees() {
		return CommonResult.success(sysDeptService.listCurrentUserDeptTrees());
	}

	/**
	 * 添加
	 * @param sysDept 实体
	 * @return success/false
	 */
	@SysLogFlag("添加部门")
	@PostMapping("/add")
	@PreAuthorize("@pms.hasPermission('sys_dept_add')")
	public CommonResult<Boolean> save(@Valid @RequestBody SysDept sysDept) {
		return CommonResult.success(sysDeptService.saveDept(sysDept));
	}

	/**
	 * 删除
	 * @param id ID
	 * @return success/false
	 */
	@SysLogFlag("删除部门")
	@DeleteMapping("/{id:\\d+}")
	@PreAuthorize("@pms.hasPermission('sys_dept_del')")
	public CommonResult<Boolean> removeById(@PathVariable Long id) {
		return CommonResult.success(sysDeptService.removeDeptById(id));
	}

	/**
	 * 编辑
	 * @param sysDept 实体
	 * @return success/false
	 */
	@SysLogFlag("编辑部门")
	@PutMapping("/update")
	@PreAuthorize("@pms.hasPermission('sys_dept_edit')")
	public CommonResult<Boolean> update(@Valid @RequestBody SysDept sysDept) {
		return CommonResult.success(sysDeptService.updateDeptById(sysDept));
	}

	/**
	 * 根据部门名查询部门信息
	 * @param deptname 部门名
	 */
	@GetMapping("/details/{deptname}")
	public CommonResult<SysDept> user(@PathVariable String deptname) {
		SysDept condition = new SysDept();
		condition.setName(deptname);
		return CommonResult.success(sysDeptService.getOne(new QueryWrapper<>(condition)));
	}

	/**
	 * 查收子级id列表
	 * @return 返回子级id列表
	 */
	@Inner
	@GetMapping(value = "/child-id/{deptId:\\d+}")
	public CommonResult<List<Long>> listChildDeptId(@PathVariable Long deptId) {
		return CommonResult.success(sysDeptService.listChildDeptId(deptId));
	}

}
