package com.obeast.product.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.SkuSaleAttrValueMapper;
import com.obeast.product.api.entity.SkuSaleAttrValueEntity;
import com.obeast.product.biz.service.SkuSaleAttrValueService;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku销售属性值
 */
@Service("skuSaleAttrValueService")
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper, SkuSaleAttrValueEntity> implements SkuSaleAttrValueService {


    @Override
    public void saveBatchSkuSaleAttrs(List<SkuSaleAttrValueEntity> skuSaleAttrValues) {
        this.saveBatch(skuSaleAttrValues);
    }
}
