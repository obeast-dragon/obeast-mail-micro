package com.obeast.product.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.product.biz.mapper.SpuImagesMapper;
import com.obeast.product.api.entity.SpuImagesEntity;
import com.obeast.product.biz.service.SpuImagesService;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-26 17:28:37
 * @version 1.0
 * Description: spu图片
 */
@Service("SpuImagesService")
public class SpuImagesServiceImpl extends ServiceImpl<SpuImagesMapper, SpuImagesEntity> implements SpuImagesService {

    @Override
    public IPage<SpuImagesEntity> pageSpuImagess(Page<SpuImagesEntity> page) {
        LambdaQueryWrapper<SpuImagesEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSpuImages(SpuImagesEntity spuImagesEntity) {
        return this.save(spuImagesEntity);
    }

    @Override
    public Boolean removeSpuImagesById(Long id) {
        return this.removeById(id);
    }


    @Override
    public Boolean updateSpuImages(SpuImagesEntity spuImagesEntity) {
        return this.updateById(spuImagesEntity);
    }


    @Override
    public void saveImages(Long id, List<String> goodsImgs) {

    }
}
