package com.obeast.product.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId(type = IdType.AUTO)
	private Long brandId;

	/**
	 * 品牌名
	 */
	private String name;

	/**
	 * 品牌logo地址
	 */
	private String logo;

	/**
	 * 介绍
	 */
	private String description;

	/**
	 * 显示状态[0-显示；1-不显示]
	 */
	private Integer showStatus;

	/**
	 * 检索首字母
	 */
	private String firstLetter;

	/**
	 * 排序
	 */
	private Integer sort;

}
