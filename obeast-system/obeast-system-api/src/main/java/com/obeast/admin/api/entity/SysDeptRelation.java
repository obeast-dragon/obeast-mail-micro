package com.obeast.admin.api.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author wxl
 * Date 2023/4/3 21:52
 * @version 1.0
 * Description: 部门关系表
 */
@Schema(description = "部门关系")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDeptRelation extends Model<SysDeptRelation> {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 祖先节点
	 */
	@Schema(description = "祖先节点")
	private Long ancestor;

	/**
	 * 后代节点
	 */
	@Schema(description = "后代节点")
	private Long descendant;

}
