package com.obeast.admin.biz.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.admin.api.entity.SysDept;
import com.obeast.admin.api.entity.SysDeptRelation;
import com.obeast.admin.biz.mapper.SysDeptMapper;
import com.obeast.admin.biz.service.SysDeptRelationService;
import com.obeast.admin.biz.service.SysDeptService;

import com.obeast.common.security.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wxl
 * Date 2023/4/10 0:21
 * @version 1.0
 * Description: 部门管理 服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

	private final SysDeptRelationService sysDeptRelationService;

	/**
	 * 添加信息部门
	 * @param dept 部门
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean saveDept(SysDept dept) {
		this.save(dept);
		sysDeptRelationService.saveDeptRelation(dept);
		return Boolean.TRUE;
	}

	/**
	 * 删除部门
	 * @param id 部门 ID
	 * @return 成功、失败
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean removeDeptById(Long id) {
		// 级联删除部门
		List<Long> idList = sysDeptRelationService
			.list(Wrappers.<SysDeptRelation>query().lambda().eq(SysDeptRelation::getAncestor, id))
			.stream()
			.map(SysDeptRelation::getDescendant)
			.collect(Collectors.toList());

		if (CollUtil.isNotEmpty(idList)) {
			this.removeByIds(idList);
		}

		// 删除部门级联关系
		sysDeptRelationService.removeDeptRelationById(id);
		return Boolean.TRUE;
	}

	/**
	 * 更新部门
	 * @param sysDept 部门信息
	 * @return 成功、失败
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean updateDeptById(SysDept sysDept) {
		// 更新部门状态
		this.updateById(sysDept);
		// 更新部门关系
		SysDeptRelation relation = new SysDeptRelation();
		relation.setAncestor(sysDept.getParentId());
		relation.setDescendant(sysDept.getDeptId());
		sysDeptRelationService.updateDeptRelation(relation);
		return Boolean.TRUE;
	}

	@Override
	public List<Long> listChildDeptId(Long deptId) {
		List<SysDeptRelation> deptRelations = sysDeptRelationService.list(Wrappers.<SysDeptRelation>lambdaQuery()
			.eq(SysDeptRelation::getAncestor, deptId)
			.ne(SysDeptRelation::getDescendant, deptId));
		if (CollUtil.isNotEmpty(deptRelations)) {
			return deptRelations.stream().map(SysDeptRelation::getDescendant).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	/**
	 * 查询全部部门树
	 * @return 树
	 */
	@Override
	public List<Tree<Long>> listDeptTrees(String deptName) {
		LambdaQueryWrapper<SysDept> lambdaQuery = Wrappers.lambdaQuery();
		if (StrUtil.isNotBlank(deptName)) {
			lambdaQuery.eq(SysDept::getName, deptName);
		}
		return getDeptTree(this.list(lambdaQuery), 0L);
	}

	/**
	 * 查询用户部门树
	 */
	@Override
	public List<Tree<Long>> listCurrentUserDeptTrees() {
		Long deptId = SecurityUtils.getUser().getDeptId();
		List<Long> descendantIdList = sysDeptRelationService
			.list(Wrappers.<SysDeptRelation>query().lambda().eq(SysDeptRelation::getAncestor, deptId))
			.stream()
			.map(SysDeptRelation::getDescendant)
			.collect(Collectors.toList());

		List<SysDept> deptList = baseMapper.selectBatchIds(descendantIdList);
		Optional<SysDept> dept = deptList.stream().filter(item -> item.getDeptId().intValue() == deptId).findFirst();
		return getDeptTree(deptList, dept.isPresent() ? dept.get().getParentId() : 0L);
	}

	/**
	 * 构建部门树
	 * @param depts 部门
	 * @param parentId 父级id
	 */
	private List<Tree<Long>> getDeptTree(List<SysDept> depts, Long parentId) {
		List<TreeNode<Long>> collect = depts.stream()
			.filter(dept -> dept.getDeptId().intValue() != dept.getParentId())
			.sorted(Comparator.comparingInt(SysDept::getSortOrder))
			.map(dept -> {
				TreeNode<Long> treeNode = new TreeNode<>();
				treeNode.setId(dept.getDeptId());
				treeNode.setParentId(dept.getParentId());
				treeNode.setName(dept.getName());
				treeNode.setWeight(dept.getSortOrder());
				// 扩展属性
				Map<String, Object> extra = new HashMap<>(2);
				extra.put("createTime", dept.getCreateTime());
				extra.put("sortOrder", dept.getSortOrder());
				treeNode.setExtra(extra);
				return treeNode;
			})
			.collect(Collectors.toList());

		return TreeUtil.build(collect, parentId);
	}

}
