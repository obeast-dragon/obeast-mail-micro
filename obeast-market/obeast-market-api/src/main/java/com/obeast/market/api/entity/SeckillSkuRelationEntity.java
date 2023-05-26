package com.obeast.market.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serial;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动商品关联
 */
@Data
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelationEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 活动id
	 */
	private Long promotionId;

	/**
	 * 活动场次id
	 */
	private Long promotionSessionId;

	/**
	 * 商品id
	 */
	private Long skuId;

	/**
	 * 秒杀价格
	 */
	private BigDecimal seckillPrice;

	/**
	 * 秒杀总量
	 */
	private Integer seckillCount;

	/**
	 * 每人限购数量
	 */
	private Integer seckillLimit;

	/**
	 * 排序
	 */
	private Integer seckillSort;

}
