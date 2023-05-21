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
 * Description: 会员收藏的商品
 */
@Data
@TableName("ums_member_collect_spu")
public class MemberCollectSpuEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 会员id
	 */
	private Long memberId;

	/**
	 * spu_id
	 */
	private Long spuId;

	/**
	 * spu_name
	 */
	private String spuName;

	/**
	 * spu_img
	 */
	private String spuImg;

	/**
	 * create_time
	 */
	private Date createTime;

}
