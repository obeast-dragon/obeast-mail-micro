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
 * Date 2023-05-21 20:31:30
 * @version 1.0
 * Description: 成长值变化历史记录
 */
@Data
@TableName("ums_growth_change_history")
public class UmsGrowthChangeHistoryEntity implements Serializable {

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
	 * 改变的值（正负计数）
	 */
	private Integer changeCount;

	/**
	 * 备注
	 */
	private String note;

	/**
	 * 积分来源[0-购物，1-管理员修改]
	 */
	private Integer sourceType;

}
