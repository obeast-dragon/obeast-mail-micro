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
 * Description: 商品会员价格
 */
@Data
@TableName("sms_member_price")
public class MemberPriceEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * sku_id
	 */
	private Long skuId;

	/**
	 * 会员等级id
	 */
	private Long memberLevelId;

	/**
	 * 会员等级名
	 */
	private String memberLevelName;

	/**
	 * 会员对应价格
	 */
	private BigDecimal memberPrice;

	/**
	 * 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
	 */
	private Integer addOther;

}
