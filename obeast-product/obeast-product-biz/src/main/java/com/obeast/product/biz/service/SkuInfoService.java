package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.SkuInfoEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku信息
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    /**
     * Description: 保存
     * @author wxl
     * Date: 2023/5/27 0:32
     * @param skuInfo skuInfo
     */
    void saveSkuInfo(SkuInfoEntity skuInfo);

    /**
     * Description: 分页查询
     * @author wxl
     * Date: 2023/5/28 10:33
     * @param page page
     * @param categoryId categoryId
     * @param brandId brandId
     * @param priceMin priceMin
     * @param priceMax priceMax
     * @param skuName  skuName
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.obeast.product.api.entity.SkuInfoEntity>
     */
    IPage<SkuInfoEntity> pageSkuInfo(Page<SkuInfoEntity> page, Long categoryId, Long brandId, BigDecimal priceMin, BigDecimal priceMax, String skuName);
}

