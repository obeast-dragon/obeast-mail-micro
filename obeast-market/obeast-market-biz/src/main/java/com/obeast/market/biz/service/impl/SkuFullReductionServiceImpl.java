package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.SkuFullReductionMapper;
import com.obeast.market.api.entity.SkuFullReductionEntity;
import com.obeast.market.biz.service.SkuFullReductionService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品满减信息
 */
@Service("SkuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionMapper, SkuFullReductionEntity> implements SkuFullReductionService {

    @Override
    public IPage<SkuFullReductionEntity> pageSkuFullReductions(Page<SkuFullReductionEntity> page) {
        LambdaQueryWrapper<SkuFullReductionEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSkuFullReduction(SkuFullReductionEntity skuFullReductionEntity) {
        return this.save(skuFullReductionEntity);
    }

    @Override
    public Boolean removeSkuFullReductionById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSkuFullReduction(SkuFullReductionEntity skuFullReductionEntity) {
        return this.updateById(skuFullReductionEntity);
    }
}
