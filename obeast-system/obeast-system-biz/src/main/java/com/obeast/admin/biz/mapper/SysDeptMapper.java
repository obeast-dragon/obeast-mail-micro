package com.obeast.admin.biz.mapper;

import com.obeast.admin.api.entity.SysDept;
import com.obeast.common.mybatis.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:18
 * @version 1.0
 * Description: 部门管理 Mapper 接口
 */
@Mapper
public interface SysDeptMapper extends BaseDao<SysDept> {

	/**
	 * 关联dept——relation
	 * @return 数据列表
	 */
	List<SysDept> listDepts();

}
