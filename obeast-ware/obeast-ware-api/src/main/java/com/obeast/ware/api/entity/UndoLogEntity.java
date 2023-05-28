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
 * Description: 
 */
@Data
@TableName("undo_log")
public class UndoLogEntity implements Serializable {

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
	private Long branchId;

	/**
	 * 
	 */
	private String xid;

	/**
	 * 
	 */
	private String context;

	/**
	 * 
	 */
	private Object rollbackInfo;

	/**
	 * 
	 */
	private Integer logStatus;

	/**
	 * 
	 */
	private Date logCreated;

	/**
	 * 
	 */
	private Date logModified;

	/**
	 * 
	 */
	private String ext;

}
