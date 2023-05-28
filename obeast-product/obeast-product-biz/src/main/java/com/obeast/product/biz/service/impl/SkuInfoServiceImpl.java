package com.obeast.product.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.product.api.entity.SkuInfoEntity;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.SkuInfoMapper;
import com.obeast.product.api.entity.SkuInfoEntity;
import com.obeast.product.biz.service.SkuInfoService;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku信息
 */
@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfoEntity> implements SkuInfoService {


    @Override
    public IPage<SkuInfoEntity> pageSkuInfo(Page<SkuInfoEntity> page, Long categoryId, Long brandId, BigDecimal priceMin, BigDecimal priceMax, String skuName) {
        LambdaQueryWrapper<SkuInfoEntity> queryWrapper = Wrappers.lambdaQuery();
        if (categoryId != null) {
            queryWrapper.eq(SkuInfoEntity::getCategoryId, categoryId);
        }
        if (brandId != null) {
            queryWrapper.eq(SkuInfoEntity::getBrandId, brandId);
        }
        if (priceMin != null && priceMax != null) {
            queryWrapper.between(SkuInfoEntity::getPrice, priceMin, priceMax);
        }
        if (StrUtil.isNotBlank(skuName)) {
            queryWrapper.like(SkuInfoEntity::getSkuName, skuName);
        }
        return this.page(page, queryWrapper);
    }

    @Override
    public void saveSkuInfo(SkuInfoEntity skuInfo) {
        this.save(skuInfo);
    }
}
