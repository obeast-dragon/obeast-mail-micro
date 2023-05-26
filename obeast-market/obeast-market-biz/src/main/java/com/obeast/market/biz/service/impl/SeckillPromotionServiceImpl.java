package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.SeckillPromotionMapper;
import com.obeast.market.api.entity.SeckillPromotionEntity;
import com.obeast.market.biz.service.SeckillPromotionService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动
 */
@Service("SeckillPromotionService")
public class SeckillPromotionServiceImpl extends ServiceImpl<SeckillPromotionMapper, SeckillPromotionEntity> implements SeckillPromotionService {

    @Override
    public IPage<SeckillPromotionEntity> pageSeckillPromotions(Page<SeckillPromotionEntity> page) {
        LambdaQueryWrapper<SeckillPromotionEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSeckillPromotion(SeckillPromotionEntity seckillPromotionEntity) {
        return this.save(seckillPromotionEntity);
    }

    @Override
    public Boolean removeSeckillPromotionById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSeckillPromotion(SeckillPromotionEntity seckillPromotionEntity) {
        return this.updateById(seckillPromotionEntity);
    }
}
