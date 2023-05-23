package com.obeast.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品属性
 */
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * 属性id
	 */
	@TableId(type = IdType.AUTO)
	private Long attrId;

	/**
	 * 属性名
	 */
	@NotNull(message = "属性名不能为空")
	private String attrName;

	/**
	 * 是否需要检索[0-不需要，1-需要]
	 */
	private Integer searchType;

	/**
	 * 值类型[0-为单个值，1-可以选择多个值]
	 */
	private Integer valueType;

	/**
	 * 可选值列表[用逗号分隔]
	 */
	@NotNull(message = "可选值列表不能为空")
	private String valueSelect;

	/**
	 * 属性类型[0-销售属性，1-基本属性
	 */
	private Integer attrType;

	/**
	 * 启用状态[0 - 启用，1 - 禁用]
	 */
	private Integer enable;

	/**
	 * 所属分类
	 */
	private Long catelogId;

	/**
	 * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
	 */
	private Integer showDesc;

	/**
	 * 属性类型[0-销售属性，1-基本属性
	 */
	private Integer sort;

}
