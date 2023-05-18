package com.obeast.admin.biz.mapper;

import com.obeast.admin.api.entity.SysDeptRelation;
import com.obeast.common.mybatis.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wxl
 * Date 2023/4/10 0:18
 * @version 1.0
 * Description: Mapper 接口
 */
@Mapper
public interface SysDeptRelationMapper extends BaseDao<SysDeptRelation> {

	/**
	 * 删除部门节点关系
	 * @param deptRelation 待删除的某一个部门节点
	 */
	void deleteDeptRelations(SysDeptRelation deptRelation);

	/**
	 * 删除部门节点关系,同时删除所有关联此部门子节点的部门关系
	 * @param id 待删除的部门节点ID
	 */
	void deleteDeptRelationsById(Long id);

	/**
	 * 新增部门节点关系
	 * @param deptRelation 待新增的部门节点关系
	 */
	void insertDeptRelations(SysDeptRelation deptRelation);

}
