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
 * Description: 秒杀活动
 */
@Data
@TableName("sms_seckill_promotion")
public class SeckillPromotionEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 活动标题
	 */
	private String title;

	/**
	 * 开始日期
	 */
	private Date startTime;

	/**
	 * 结束日期
	 */
	private Date endTime;

	/**
	 * 上下线状态
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建人
	 */
	private Long userId;

}
