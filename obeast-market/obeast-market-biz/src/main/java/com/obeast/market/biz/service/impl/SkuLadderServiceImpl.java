package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.SkuLadderMapper;
import com.obeast.market.api.entity.SkuLadderEntity;
import com.obeast.market.biz.service.SkuLadderService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品阶梯价格
 */
@Service("SkuLadderService")
public class SkuLadderServiceImpl extends ServiceImpl<SkuLadderMapper, SkuLadderEntity> implements SkuLadderService {

    @Override
    public IPage<SkuLadderEntity> pageSkuLadders(Page<SkuLadderEntity> page) {
        LambdaQueryWrapper<SkuLadderEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSkuLadder(SkuLadderEntity skuLadderEntity) {
        return this.save(skuLadderEntity);
    }

    @Override
    public Boolean removeSkuLadderById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSkuLadder(SkuLadderEntity skuLadderEntity) {
        return this.updateById(skuLadderEntity);
    }
}
