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
 * Description: 商品三级分类
 */
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * 分类id
	 */
	@TableId(type = IdType.AUTO)
	private Long catId;

	/**
	 * 分类名称
	 */
	private String name;

	/**
	 * 父分类id
	 */
	private Long parentId;

	/**
	 * 层级
	 */
	private Integer catLevel;

	/**
	 * 是否显示[0-显示，1-不显示]
	 */
	private Integer showStatus;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 图标地址
	 */
	private String icon;

	/**
	 * 计量单位
	 */
	private String productUnit;

	/**
	 * 商品数量
	 */
	private Integer productCount;

}
