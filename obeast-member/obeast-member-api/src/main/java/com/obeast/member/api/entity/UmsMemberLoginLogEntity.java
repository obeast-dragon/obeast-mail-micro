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
 * Description: 会员登录记录
 */
@Data
@TableName("ums_member_login_log")
public class UmsMemberLoginLogEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * member_id
	 */
	private Long memberId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * ip
	 */
	private String ip;

	/**
	 * city
	 */
	private String city;

	/**
	 * 登录类型[1-web，2-app]
	 */
	private Integer loginType;

}
