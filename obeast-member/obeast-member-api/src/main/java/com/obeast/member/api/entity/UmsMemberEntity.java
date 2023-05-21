package com.obeast.member.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


/**
 * @author wxl
 * Date 2023-05-21 20:31:30
 * @version 1.0
 * Description: 会员
 */
@Data
@TableName("ums_member")
public class UmsMemberEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 会员等级id
	 */
	private Long levelId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 头像
	 */
	private String header;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 生日
	 */
	private Date birth;

	/**
	 * 所在城市
	 */
	private String city;

	/**
	 * 职业
	 */
	private String job;

	/**
	 * 个性签名
	 */
	private String sign;

	/**
	 * 用户来源
	 */
	private Integer sourceType;

	/**
	 * 积分
	 */
	private Integer integration;

	/**
	 * 成长值
	 */
	private Integer growth;

	/**
	 * 启用状态
	 */
	private Integer status;

	/**
	 * 注册时间
	 */
	private Date createTime;

	/**
	 * 社交用户的唯一id
	 */
	private String socialUid;

	/**
	 * 访问令牌
	 */
	private String accessToken;

	/**
	 * 访问令牌的时间
	 */
	private String expiresIn;

}
