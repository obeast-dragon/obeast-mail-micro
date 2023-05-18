package com.obeast.admin.biz.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysDept;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:22
 * @version 1.0
 * Description: 部门管理 服务类
 */
public interface SysDeptService extends IService<SysDept> {

	/**
	 * 查询部门树菜单
	 * @param  deptName deptName
	 * @return 树
	 */
	List<Tree<Long>> listDeptTrees(String deptName);

	/**
	 * 查询用户部门树
	 */
	List<Tree<Long>> listCurrentUserDeptTrees();

	/**
	 * 添加信息部门
	 * @param sysDept sysDept
	 */
	Boolean saveDept(SysDept sysDept);

	/**
	 * 删除部门
	 * @param id 部门 ID
	 * @return 成功、失败
	 */
	Boolean removeDeptById(Long id);

	/**
	 * 更新部门
	 * @param sysDept 部门信息
	 * @return 成功、失败
	 */
	Boolean updateDeptById(SysDept sysDept);

	/**
	 * 查找指定部门的子部门id列表
	 * @param deptId 部门id
	 * @return List<Long>
	 */
	List<Long> listChildDeptId(Long deptId);

}
