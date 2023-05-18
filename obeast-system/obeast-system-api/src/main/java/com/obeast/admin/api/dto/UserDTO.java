package com.obeast.admin.api.dto;

import com.obeast.admin.api.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:14
 * @version 1.0
 * Description: UserDTO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends SysUser {

	/**
	 * 角色ID
	 */
	private List<Long> roleList;

	/**
	 * 岗位ID
	 */
	private List<Long> postList;

	/**
	 * 新密码
	 */
	private String newpassword1;

	/**
	 * 验证码
	 */
	private String code;

}
