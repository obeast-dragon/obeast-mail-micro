package com.obeast.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serial;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.Data;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku信息
 */
@Data
@TableName("pms_sku_info")
public class SkuInfoEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * skuId
	 */
	@TableId(type = IdType.AUTO)
	private Long skuId;

	/**
	 * spuId
	 */
	private Long spuId;

	/**
	 * sku名称
	 */
	private String skuName;

	/**
	 * sku介绍描述
	 */
	private String skuDesc;

	/**
	 * 所属分类id
	 */
	private Long categoryId;

	/**
	 * 品牌id
	 */
	private Long brandId;

	/**
	 * 默认图片
	 */
	private String skuDefaultImg;

	/**
	 * 标题
	 */
	private String skuTitle;

	/**
	 * 副标题
	 */
	private String skuSubtitle;

	/**
	 * 价格
	 */
	private BigDecimal price;

	/**
	 * 销量
	 */
	private Long saleCount;

}
