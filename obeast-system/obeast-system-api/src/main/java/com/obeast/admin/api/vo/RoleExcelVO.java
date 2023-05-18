package com.obeast.admin.api.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wxl
 * Date 2023/5/14 13:35
 * @version 1.0
 * Description: 角色excel 对应的实体
 */
@Data
@ColumnWidth(30)
public class RoleExcelVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * excel 行号
	 */
	@ExcelIgnore
	private Long lineNum;

	/**
	 * 主键ID
	 */
	@ExcelProperty("角色编号")
	private Long roleId;

	/**
	 * 角色名称
	 */
	@NotBlank(message = "角色名称不能为空")
	@ExcelProperty("角色名称")
	private String roleName;

	/**
	 * 角色标识
	 */
	@NotBlank(message = "角色标识不能为空")
	@ExcelProperty("角色标识")
	private String roleCode;

	/**
	 * 角色描述
	 */
	@NotBlank(message = "角色描述不能为空")
	@ExcelProperty("角色描述")
	private String roleDesc;

	/**
	 * 创建时间
	 */
	@ExcelProperty(value = "创建时间")
	private LocalDateTime createTime;

}
