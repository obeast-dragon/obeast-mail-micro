package com.obeast.product.biz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.BrandMapper;
import com.obeast.product.api.entity.BrandEntity;
import com.obeast.product.biz.service.BrandService;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌
 */
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements BrandService {

    @Override
    public IPage<BrandEntity> pageBrands(Page<BrandEntity> page) {
        return this.page(page);
    }

    @Override
    public Boolean saveBrand(BrandEntity brandEntity) {
        return this.save(brandEntity);
    }

    @Override
    public Boolean removeBrandById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateBrand(BrandEntity brandEntity) {
        return this.updateById(brandEntity);
    }
}
