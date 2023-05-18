package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysDictItem;

/**
 * @author wxl
 * Date 2023/4/10 0:22
 * @version 1.0
 * Description: 字典项
 */
public interface SysDictItemService extends IService<SysDictItem> {

	/**
	 * 删除字典项
	 * @param id 字典项ID
	 */
	void removeDictItem(Long id);

	/**
	 * 更新字典项
	 * @param item 字典项
	 */
	void updateDictItem(SysDictItem item);

}
