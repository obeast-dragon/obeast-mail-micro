package com.obeast.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.obeast.common.mybatis.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serial;

/**
 * @author wxl
 * Date 2023/4/3 21:57
 * @version 1.0
 * Description: 角色表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

	@TableId(value = "role_id", type = IdType.ASSIGN_ID)
	@Schema(description = "角色编号")
	private Long roleId;

	@NotBlank(message = "角色名称 不能为空")
	@Schema(description = "角色名称")
	private String roleName;

	@NotBlank(message = "角色标识 不能为空")
	@Schema(description = "角色标识")
	private String roleCode;

	@NotBlank(message = "角色描述 不能为空")
	@Schema(description = "角色描述")
	private String roleDesc;

	/**
	 * 删除标识（0-正常,1-删除）
	 */
	@TableLogic
	private String delFlag;

}
