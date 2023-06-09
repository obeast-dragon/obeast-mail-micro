package com.obeast.admin.api.vo;

import com.obeast.admin.api.entity.SysPost;
import com.obeast.admin.api.entity.SysRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wxl
 * Date 2023/4/30 23:05
 * @version 1.0
 * Description:
 */
@Data
public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 随机盐
	 */
	private String salt;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 0-正常，1-删除
	 */
	private String delFlag;

	/**
	 * 锁定标记
	 */
	private String lockFlag;

	/**
	 * 简介
	 */
	private String phone;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 头像
	 */
	private String email;


	/**
	 * 部门ID
	 */
	private Long deptId;

	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 角色列表
	 */
	private List<SysRole> roleList;

	/**
	 * 岗位列表
	 */
	private List<SysPost> postList;

}
