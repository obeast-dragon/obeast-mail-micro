package com.obeast.product.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.product.biz.mapper.SkuImagesMapper;
import com.obeast.product.api.entity.SkuImagesEntity;
import com.obeast.product.biz.service.SkuImagesService;



/**
 * @author wxl
 * Date 2023-05-26 17:28:37
 * @version 1.0
 * Description: sku图片
 */
@Service("SkuImagesService")
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesMapper, SkuImagesEntity> implements SkuImagesService {

    @Override
    public IPage<SkuImagesEntity> pageSkuImagess(Page<SkuImagesEntity> page) {
        LambdaQueryWrapper<SkuImagesEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSkuImages(SkuImagesEntity skuImagesEntity) {
        return this.save(skuImagesEntity);
    }

    @Override
    public Boolean removeSkuImagesById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSkuImages(SkuImagesEntity skuImagesEntity) {
        return this.updateById(skuImagesEntity);
    }
}
