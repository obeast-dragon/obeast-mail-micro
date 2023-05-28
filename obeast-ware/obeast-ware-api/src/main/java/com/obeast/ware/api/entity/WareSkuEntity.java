package com.obeast.ware.api.entity;

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
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 商品库存
 */
@Data
@TableName("wms_ware_sku")
public class WareSkuEntity implements Serializable {

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
	 * 仓库id
	 */
	private Long wareId;

	/**
	 * 库存数
	 */
	private Integer stock;

	/**
	 * sku_name
	 */
	private String skuName;

	/**
	 * 锁定库存
	 */
	private Integer stockLocked;

}
