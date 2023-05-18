package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysPost;
import com.obeast.admin.api.vo.PostExcelVO;
import com.obeast.common.core.base.CommonResult;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:24
 * @version 1.0
 * Description: 岗位管理 服务类
 */
public interface SysPostService extends IService<SysPost> {

	/**
	 * 导入岗位
	 * @param excelVOList 岗位列表
	 * @param bindingResult 错误信息列表
	 * @return ok fail
	 */
	CommonResult<?> importPost(List<PostExcelVO> excelVOList, BindingResult bindingResult);

	/**
	 * 导出excel 表格
	 * @return
	 */
	List<PostExcelVO> listPost();

}
