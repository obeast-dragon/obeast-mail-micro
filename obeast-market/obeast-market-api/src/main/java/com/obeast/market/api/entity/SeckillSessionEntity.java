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
 * Description: 秒杀活动场次
 */
@Data
@TableName("sms_seckill_session")
public class SeckillSessionEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 场次名称
	 */
	private String name;

	/**
	 * 每日开始时间
	 */
	private Date startTime;

	/**
	 * 每日结束时间
	 */
	private Date endTime;

	/**
	 * 启用状态
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	private Date createTime;

}
