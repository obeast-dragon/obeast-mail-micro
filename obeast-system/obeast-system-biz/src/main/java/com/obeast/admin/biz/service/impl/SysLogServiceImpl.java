package com.obeast.admin.biz.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.admin.api.dto.SysLogDTO;
import com.obeast.admin.api.entity.SysLog;
import com.obeast.admin.biz.mapper.SysLogMapper;
import com.obeast.admin.biz.service.SysLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:21
 * @version 1.0
 * Description: 日志表 服务实现类
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

	@Override
	public Page getLogByPage(Page page, SysLogDTO sysLog) {
		return baseMapper.selectPage(page, buildQueryWrapper(sysLog));
	}

	/**
	 * 列表查询日志
	 * @param sysLog 查询条件
	 * @return List
	 */
	@Override
	public List getLogList(SysLogDTO sysLog) {
		return baseMapper.selectList(buildQueryWrapper(sysLog));
	}

	/**
	 * 构建查询的 wrapper
	 * @param sysLog 查询条件
	 * @return LambdaQueryWrapper
	 */
	private LambdaQueryWrapper buildQueryWrapper(SysLogDTO sysLog) {
		LambdaQueryWrapper<SysLog> wrapper = Wrappers.<SysLog>lambdaQuery()
			.eq(StrUtil.isNotBlank(sysLog.getType()), SysLog::getType, sysLog.getType())
			.like(StrUtil.isNotBlank(sysLog.getRemoteAddr()), SysLog::getRemoteAddr, sysLog.getRemoteAddr());

		if (ArrayUtil.isNotEmpty(sysLog.getCreateTime())) {
			wrapper.ge(SysLog::getCreateTime, sysLog.getCreateTime()[0])
				.le(SysLog::getCreateTime, sysLog.getCreateTime()[1]);
		}

		return wrapper;
	}

}
