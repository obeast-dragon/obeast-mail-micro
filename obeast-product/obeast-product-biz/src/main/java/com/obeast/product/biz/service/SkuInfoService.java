package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.SkuInfoEntity;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku信息
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

}

