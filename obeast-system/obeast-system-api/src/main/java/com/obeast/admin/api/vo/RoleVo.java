package com.obeast.admin.api.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author wxl
 * Date 2023/5/14 13:34
 * @version 1.0
 * Description:
 */
@Data
@Schema(description = "前端角色展示对象")
public class RoleVo {

	/**
	 * 角色id
	 */
	private Long roleId;

	/**
	 * 菜单列表
	 */
	private List<Long> menuIds;

}
