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
	 * 
	 */
	private Long assigneeId;

	/**
	 * 
	 */
	private String assigneeName;

	/**
	 * 
	 */
	private String phone;

	/**
	 * 
	 */
	private Integer priority;

	/**
	 * 
	 */
	private Integer status;

	/**
	 * 
	 */
	private Long wareId;

	/**
	 * 
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
