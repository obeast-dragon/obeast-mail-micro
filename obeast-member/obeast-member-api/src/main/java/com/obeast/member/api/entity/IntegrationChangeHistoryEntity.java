package com.obeast.member.api.entity;

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
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 积分变化历史记录
 */
@Data
@TableName("ums_integration_change_history")
public class IntegrationChangeHistoryEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * member_id
	 */
	private Long memberId;

	/**
	 * create_time
	 */
	private Date createTime;

	/**
	 * 变化的值
	 */
	private Integer changeCount;

	/**
	 * 备注
	 */
	private String note;

	/**
	 * 来源[0->购物；1->管理员修改;2->活动]
	 */
	private Integer sourceTyoe;

}
