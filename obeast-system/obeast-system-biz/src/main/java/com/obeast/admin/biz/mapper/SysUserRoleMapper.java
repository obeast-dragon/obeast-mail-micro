package com.obeast.admin.biz.mapper;

import com.obeast.admin.api.entity.SysUserRole;
import com.obeast.common.mybatis.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxl
 * Date 2023/4/10 0:20
 * @version 1.0
 * Description: 用户角色表 Mapper 接口
 */
@Mapper
public interface SysUserRoleMapper extends BaseDao<SysUserRole> {

	/**
	 * 根据用户Id删除该用户的角色关系
	 * @param userId 用户ID
	 * @return boolean
	 * @author 寻欢·李
	 */
	Boolean deleteByUserId(@Param("userId") Long userId);

}
