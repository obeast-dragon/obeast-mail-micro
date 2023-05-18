package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysRole;
import com.obeast.admin.api.vo.RoleExcelVO;
import com.obeast.common.core.base.CommonResult;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:24
 * @version 1.0
 * Description: 服务类
 */
public interface SysRoleService extends IService<SysRole> {

	/**
	 * 通过角色ID，删除角色
	 * @param id
	 * @return
	 */
	Boolean removeRoleById(Long id);

	/**
	 * 导入角色
	 * @param excelVOList 角色列表
	 * @param bindingResult 错误信息列表
	 * @return ok fail
	 */
	CommonResult<?> importRole(List<RoleExcelVO> excelVOList, BindingResult bindingResult);

	/**
	 * 查询全部的角色
	 * @return list
	 */
	List<RoleExcelVO> listRole();

}
