package com.obeast.product.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.SkuInfoMapper;
import com.obeast.product.api.entity.SkuInfoEntity;
import com.obeast.product.biz.service.SkuInfoService;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku信息
 */
@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfoEntity> implements SkuInfoService {


    @Override
    public void saveSkuInfo(SkuInfoEntity skuInfoEntity) {

    }
}
