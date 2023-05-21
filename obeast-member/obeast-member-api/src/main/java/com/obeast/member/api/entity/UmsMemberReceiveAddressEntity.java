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
 * Description: 会员收货地址
 */
@Data
@TableName("ums_member_receive_address")
public class UmsMemberReceiveAddressEntity implements Serializable {

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
	 * 收货人姓名
	 */
	private String name;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 邮政编码
	 */
	private String postCode;

	/**
	 * 省份/直辖市
	 */
	private String province;

	/**
	 * 城市
	 */
	private String city;

	/**
	 * 区
	 */
	private String region;

	/**
	 * 详细地址(街道)
	 */
	private String detailAddress;

	/**
	 * 省市区代码
	 */
	private String areacode;

	/**
	 * 是否默认
	 */
	private Integer defaultStatus;

}
