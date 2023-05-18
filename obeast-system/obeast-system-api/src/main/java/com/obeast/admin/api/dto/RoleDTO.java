package com.obeast.admin.api.dto;

import com.obeast.admin.api.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wxl
 * Date 2023/4/10 0:14
 * @version 1.0
 * Description: 角色Dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends SysRole {

	/**
	 * 角色部门Id
	 */
	private Long roleDeptId;

	/**
	 * 部门名称
	 */
	private String deptName;

}
