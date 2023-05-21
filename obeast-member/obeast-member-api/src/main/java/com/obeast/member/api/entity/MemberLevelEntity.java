package com.obeast.member.api.entity;

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
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员等级
 */
@Data
@TableName("ums_member_level")
public class MemberLevelEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 等级名称
	 */
	private String name;

	/**
	 * 等级需要的成长值
	 */
	private Integer growthPoint;

	/**
	 * 是否为默认等级[0->是；1->不是]
	 */
	private Integer defaultStatus;

	/**
	 * 免运费标准
	 */
	private BigDecimal freeFreightPoint;

	/**
	 * 每次评价获取的成长值
	 */
	private Integer commentGrowthPoint;

	/**
	 * 是否有免邮特权[0->是；1->不是]
	 */
	private Integer priviledgeFreeFreight;

	/**
	 * 是否有会员价格特权[0->是；1->不是]
	 */
	private Integer priviledgeMemberPrice;

	/**
	 * 是否有生日特权[0->是；1->不是]
	 */
	private Integer priviledgeBirthday;

	/**
	 * 备注
	 */
	private String note;

}
