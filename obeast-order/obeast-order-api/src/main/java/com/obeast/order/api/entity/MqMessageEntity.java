package com.obeast.order.api.entity;

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
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 
 */
@Data
@TableName("mq_message")
public class MqMessageEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private String messageId;

	/**
	 * 
	 */
	private String content;

	/**
	 * 
	 */
	private String toExchane;

	/**
	 * 
	 */
	private String routingKey;

	/**
	 * 
	 */
	private String classType;

	/**
	 * 0-新建 1-已发送 2-错误抵达 3-已抵达
	 */
	private Integer messageStatus;

	/**
	 * 
	 */
	private Date createTime;

	/**
	 * 
	 */
	private Date updateTime;

}
