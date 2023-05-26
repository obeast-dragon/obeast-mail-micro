package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.SeckillSessionMapper;
import com.obeast.market.api.entity.SeckillSessionEntity;
import com.obeast.market.biz.service.SeckillSessionService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动场次
 */
@Service("SeckillSessionService")
public class SeckillSessionServiceImpl extends ServiceImpl<SeckillSessionMapper, SeckillSessionEntity> implements SeckillSessionService {

    @Override
    public IPage<SeckillSessionEntity> pageSeckillSessions(Page<SeckillSessionEntity> page) {
        LambdaQueryWrapper<SeckillSessionEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSeckillSession(SeckillSessionEntity seckillSessionEntity) {
        return this.save(seckillSessionEntity);
    }

    @Override
    public Boolean removeSeckillSessionById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSeckillSession(SeckillSessionEntity seckillSessionEntity) {
        return this.updateById(seckillSessionEntity);
    }
}
