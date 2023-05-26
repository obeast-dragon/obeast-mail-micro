package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.SeckillSkuRelationMapper;
import com.obeast.market.api.entity.SeckillSkuRelationEntity;
import com.obeast.market.biz.service.SeckillSkuRelationService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动商品关联
 */
@Service("SeckillSkuRelationService")
public class SeckillSkuRelationServiceImpl extends ServiceImpl<SeckillSkuRelationMapper, SeckillSkuRelationEntity> implements SeckillSkuRelationService {

    @Override
    public IPage<SeckillSkuRelationEntity> pageSeckillSkuRelations(Page<SeckillSkuRelationEntity> page) {
        LambdaQueryWrapper<SeckillSkuRelationEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSeckillSkuRelation(SeckillSkuRelationEntity seckillSkuRelationEntity) {
        return this.save(seckillSkuRelationEntity);
    }

    @Override
    public Boolean removeSeckillSkuRelationById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSeckillSkuRelation(SeckillSkuRelationEntity seckillSkuRelationEntity) {
        return this.updateById(seckillSkuRelationEntity);
    }
}
