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
 * Description: spu属性值
 */
@Data
@TableName("pms_spu_attr_value")
public class SpuAttrValueEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 商品id
	 */
	private Long spuId;

	/**
	 * 属性id
	 */
	private Long attrId;

	/**
	 * 属性名
	 */
	private String attrName;

	/**
	 * 属性值
	 */
	private String attrValue;

	/**
	 * 顺序
	 */
	private Integer attrSort;

	/**
	 * 快速展示【是否展示在介绍上；0-否 1-是】
	 */
	private Integer quickShow;

}
