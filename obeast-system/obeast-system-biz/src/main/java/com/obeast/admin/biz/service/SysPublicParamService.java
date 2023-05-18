package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysPublicParam;
import com.obeast.common.core.base.CommonResult;

/**
 * @author wxl
 * Date 2023/4/10 0:24
 * @version 1.0
 * Description: 公共参数配置
 */
public interface SysPublicParamService extends IService<SysPublicParam> {

	/**
	 * 通过key查询公共参数指定值
	 * @param publicKey
	 * @return
	 */
	String getSysPublicParamKeyToValue(String publicKey);

	/**
	 * 更新参数
	 * @param sysPublicParam
	 * @return CommonResult<?>
	 */
	CommonResult<?> updateParam(SysPublicParam sysPublicParam);

	/**
	 * 删除参数
	 * @param publicId
	 * @return CommonResult<?>
	 */
	CommonResult<?> removeParam(Long publicId);

	/**
	 * 同步缓存
	 * @return CommonResult<?>
	 */
	CommonResult<?> syncParamCache();

}
