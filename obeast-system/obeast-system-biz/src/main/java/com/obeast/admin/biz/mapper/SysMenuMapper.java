package com.obeast.admin.biz.mapper;

import com.obeast.admin.api.entity.SysMenu;
import com.obeast.common.mybatis.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @author wxl
 * Date 2023/4/10 0:19
 * @version 1.0
 * Description: 菜单权限表 Mapper 接口
 */
@Mapper
public interface SysMenuMapper extends BaseDao<SysMenu> {

	/**
	 * 通过角色编号查询菜单
	 * @param roleId 角色ID
	 */
	Set<SysMenu> listMenusByRoleId(Long roleId);

}
