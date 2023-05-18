package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysDict;

/**
 * @author wxl
 * Date 2023/4/10 0:22
 * @version 1.0
 * Description: 字典表
 */
public interface SysDictService extends IService<SysDict> {

	/**
	 * 根据ID 删除字典
	 * @param id id
	 */
	void removeDict(Long id);

	/**
	 * 更新字典
	 * @param sysDict 字典
	 */
	void updateDict(SysDict sysDict);

	/**
	 * 清除缓存
	 */
	void clearDictCache();

}
