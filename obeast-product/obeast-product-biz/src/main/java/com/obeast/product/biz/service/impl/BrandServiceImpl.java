package com.obeast.product.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.api.entity.BrandEntity;
import com.obeast.product.biz.mapper.BrandMapper;
import com.obeast.product.biz.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌
 */
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements BrandService {

    @Override
    public IPage<BrandEntity> pageBrands(Page<BrandEntity> page, String name) {
        LambdaQueryWrapper<BrandEntity> queryWrapper = Wrappers.lambdaQuery();
        if (StrUtil.isNotBlank(name)){
            queryWrapper.eq(BrandEntity::getName, name);
        }
        queryWrapper.orderByAsc(BrandEntity::getSort);
        return this.page(page, queryWrapper);
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

    @Override
    public List<BrandEntity> listBrands() {
        return this.list();
    }
}
