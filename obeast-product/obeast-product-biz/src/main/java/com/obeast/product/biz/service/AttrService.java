package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.AttrEntity;

import java.util.List;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品属性
 */
public interface AttrService extends IService<AttrEntity> {

    /**
     * Description: 分页
     * @author wxl
     * Date: 2023/5/24 19:26
     * @param page page
     * @param attrName attrName
     * @param valueType  valueType
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.obeast.product.api.entity.AttrEntity>
     */
    IPage<AttrEntity> pageAttrs(Page<AttrEntity> page, String attrName, Integer valueType);


    /**
     * Description: 保存属性
     * @author wxl
     * Date: 2023/5/24 19:27
     * @param attrEntity  attrEntity
     * @return java.lang.Boolean
     */
    Boolean saveAttr(AttrEntity attrEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/24 19:27
     * @param id  id
     * @return java.lang.Boolean
     */
    Boolean removeAttrById(Long id);


    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/24 19:27
     * @param attrEntity  attrEntity
     * @return java.lang.Boolean
     */
    Boolean updateAttr(AttrEntity attrEntity);

    /**
     * Description: 获取属性分组的关联的所有销售属性
     * @author wxl
     * Date: 2023/5/24 19:27
     * @param categoryId categoryId
     * @return List<AttrEntity>
     */
    List<AttrEntity> listAttrSaleListCategoryId(Long categoryId);
}

