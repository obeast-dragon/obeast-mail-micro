package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.SkuSaleAttrValueEntity;

import java.util.List;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku销售属性值
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    /**
     * Description: 批处理保存
     * @author wxl
     * Date: 2023/5/27 0:34
     * @param skuSaleAttrValues skuSaleAttrValues
     */
    void saveBatchSkuSaleAttrs(List<SkuSaleAttrValueEntity> skuSaleAttrValues);

}

