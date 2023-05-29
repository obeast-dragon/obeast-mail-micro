package com.obeast.ware.api.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购单
 */
@Data
@TableName("wms_purchase")
public class PurchaseEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 采购人Id
	 */
	private Long assigneeId;

	/**
	 * 采购人名
	 */
	private String assigneeName;

	/**
	 * 联系方式
	 */
	private String phone;

	/**
	 * 优先级
	 */
	private Integer priority;

	/**
	 * 状态[0- 新建; 1- 已分配; 2- 已领取; 3- 已完成; 4-有异常]
	 */
	private Integer status;

	/**
	 * 仓库Id
	 */
	private Long wareId;

	/**
	 * 金额
	 */
	private BigDecimal amount;

	/**
	 *
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 *
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

}
