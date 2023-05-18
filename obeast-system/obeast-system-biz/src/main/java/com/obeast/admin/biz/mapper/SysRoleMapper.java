package com.obeast.admin.biz.mapper;

import com.obeast.admin.api.entity.SysRole;
import com.obeast.common.mybatis.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:20
 * @version 1.0
 * Description: Mapper 接口
 */
@Mapper
public interface SysRoleMapper extends BaseDao<SysRole> {

	/**
	 * 通过用户ID，查询角色信息
	 * @param userId userId
	 */
	List<SysRole> listRolesByUserId(Long userId);

}
