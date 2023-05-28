package com.obeast.ware.api.entity;

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
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购需求
 */
@Data
@TableName("wms_purchase_detail")
public class PurchaseDetailEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 采购单id
	 */
	private Long purchaseId;

	/**
	 * 采购商品id
	 */
	private Long skuId;

	/**
	 * 采购数量
	 */
	private Integer skuNum;

	/**
	 * 采购金额
	 */
	private BigDecimal skuPrice;

	/**
	 * 仓库id
	 */
	private Long wareId;

	/**
	 * 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
	 */
	private Integer status;

}
