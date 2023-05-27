package com.obeast.product.api.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.obeast.common.mybatis.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: spu信息
 */
@Data
@TableName("pms_spu_info")
public class SpuInfoEntity implements Serializable {

	@Serial
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;


	/**
	 * 商品id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 商品名称
	 */
	private String spuName;

	/**
	 * 商品描述
	 */
	private String spuDescription;

	/**
	 * 所属分类id
	 */
	private Long categoryId;

	/**
	 * 品牌id
	 */
	private Long brandId;

	/**
	 * 
	 */
	private BigDecimal weight;

	/**
	 * 上架状态[0 - 下架，1 - 上架]
	 */
	private Integer publishStatus;

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
