package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysRoleMenu;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:24
 * @version 1.0
 * Description: 角色菜单表 服务类
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

	/**
	 * 更新角色菜单
	 * @param roleId 角色
	 * @param menuIds 菜单IDs
	 */
	Boolean saveRoleMenus(Long roleId, List<Long> menuIds);


	/**
	 * Description: 查询角色菜单
	 * @author wxl
	 * Date: 2023/5/14 22:31
	 * @param roleId  roleId
	 * @return java.util.List<java.lang.Long>
	 */
    List<Long> getMenuIdsByRoleId(Long roleId);
}
