package com.obeast.market.api.entity;

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
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 首页轮播广告
 */
@Data
@TableName("sms_home_adv")
public class HomeAdvEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 名字
	 */
	private String name;

	/**
	 * 图片地址
	 */
	private String pic;

	/**
	 * 开始时间
	 */
	private Date startTime;

	/**
	 * 结束时间
	 */
	private Date endTime;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 点击数
	 */
	private Integer clickCount;

	/**
	 * 广告详情连接地址
	 */
	private String url;

	/**
	 * 备注
	 */
	private String note;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 发布者
	 */
	private Long publisherId;

	/**
	 * 审核者
	 */
	private Long authId;

}
