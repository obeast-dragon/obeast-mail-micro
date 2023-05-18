package com.obeast.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku销售属性值
 */
@Data
@TableName("pms_sku_sale_attr_value")
public class SkuSaleAttrValueEntity implements Serializable {

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
	 * attr_id
	 */
	private Long attrId;

	/**
	 * 销售属性名
	 */
	private String attrName;

	/**
	 * 销售属性值
	 */
	private String attrValue;

	/**
	 * 顺序
	 */
	private Integer attrSort;

}
