package com.obeast.order.api.entity;

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
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单项信息
 */
@Data
@TableName("oms_order_item")
public class OrderItemEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * order_id
	 */
	private Long orderId;

	/**
	 * order_sn
	 */
	private String orderSn;

	/**
	 * spu_id
	 */
	private Long spuId;

	/**
	 * spu_name
	 */
	private String spuName;

	/**
	 * spu_pic
	 */
	private String spuPic;

	/**
	 * 品牌
	 */
	private String spuBrand;

	/**
	 * 商品分类id
	 */
	private Long categoryId;

	/**
	 * 商品sku编号
	 */
	private Long skuId;

	/**
	 * 商品sku名字
	 */
	private String skuName;

	/**
	 * 商品sku图片
	 */
	private String skuPic;

	/**
	 * 商品sku价格
	 */
	private BigDecimal skuPrice;

	/**
	 * 商品购买的数量
	 */
	private Integer skuQuantity;

	/**
	 * 商品销售属性组合（JSON）
	 */
	private String skuAttrsVals;

	/**
	 * 商品促销分解金额
	 */
	private BigDecimal promotionAmount;

	/**
	 * 优惠券优惠分解金额
	 */
	private BigDecimal couponAmount;

	/**
	 * 积分优惠分解金额
	 */
	private BigDecimal integrationAmount;

	/**
	 * 该商品经过优惠后的分解金额
	 */
	private BigDecimal realAmount;

	/**
	 * 赠送积分
	 */
	private Integer giftIntegration;

	/**
	 * 赠送成长值
	 */
	private Integer giftGrowth;

}
