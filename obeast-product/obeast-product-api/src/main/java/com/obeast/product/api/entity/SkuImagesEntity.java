package com.obeast.product.api.entity;

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
 * Date 2023-05-26 17:28:37
 * @version 1.0
 * Description: sku图片
 */
@Data
@TableName("pms_sku_images")
public class SkuImagesEntity implements Serializable {

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
	 * 图片地址
	 */
	private String imgUrl;

	/**
	 * 排序
	 */
	private Integer imgSort;

	/**
	 * 默认图[0 - 不是默认图，1 - 是默认图]
	 */
	private Integer defaultImg;

}
