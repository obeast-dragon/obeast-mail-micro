package com.obeast.admin.api.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author wxl
 * Date 2023/4/3 21:58
 * @version 1.0
 * Description: 角色菜单表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenu extends Model<SysRoleMenu> {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	@Schema(description = "角色id")
	private Long roleId;

	/**
	 * 菜单ID
	 */
	@Schema(description = "菜单id")
	private Long menuId;

}
