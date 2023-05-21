package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.AttrEntity;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品属性
 */
public interface AttrService extends IService<AttrEntity> {

    IPage<AttrEntity> pageAttrs(Page<AttrEntity> page, String attrName, Integer valueType);

    Boolean saveAttr(AttrEntity attrEntity);

    Boolean removeAttrById(Long id);

    Boolean updateAttr(AttrEntity attrEntity);
}

