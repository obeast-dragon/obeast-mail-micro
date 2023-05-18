package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.dto.SysLogDTO;
import com.obeast.admin.api.entity.SysLog;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:23
 * @version 1.0
 * Description: 日志表 服务类
 */
public interface SysLogService extends IService<SysLog> {

	/**
	 * 分页查询日志
	 * @param page page
	 * @param sysLog sysLog
	 */
	Page<SysLog> getLogByPage(Page page, SysLogDTO sysLog);

	/**
	 * 列表查询日志
	 * @param sysLog 查询条件
	 * @return List
	 */
	List<SysLog> getLogList(SysLogDTO sysLog);

}
