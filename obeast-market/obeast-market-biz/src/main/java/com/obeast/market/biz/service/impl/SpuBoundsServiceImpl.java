package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.SpuBoundsMapper;
import com.obeast.market.api.entity.SpuBoundsEntity;
import com.obeast.market.biz.service.SpuBoundsService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品spu积分设置
 */
@Service("SpuBoundsService")
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsMapper, SpuBoundsEntity> implements SpuBoundsService {

    @Override
    public IPage<SpuBoundsEntity> pageSpuBounds(Page<SpuBoundsEntity> page) {
        LambdaQueryWrapper<SpuBoundsEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSpuBounds(SpuBoundsEntity spuBoundsEntity) {
//        return this.save(spuBoundsEntity);
        return Boolean.FALSE;
    }

    @Override
    public Boolean removeSpuBoundsById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSpuBounds(SpuBoundsEntity spuBoundsEntity) {
        return this.updateById(spuBoundsEntity);
    }
}
