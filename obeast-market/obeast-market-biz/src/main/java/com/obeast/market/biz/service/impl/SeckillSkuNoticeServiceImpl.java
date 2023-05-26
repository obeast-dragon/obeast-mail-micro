package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.SeckillSkuNoticeMapper;
import com.obeast.market.api.entity.SeckillSkuNoticeEntity;
import com.obeast.market.biz.service.SeckillSkuNoticeService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀商品通知订阅
 */
@Service("SeckillSkuNoticeService")
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeMapper, SeckillSkuNoticeEntity> implements SeckillSkuNoticeService {

    @Override
    public IPage<SeckillSkuNoticeEntity> pageSeckillSkuNotices(Page<SeckillSkuNoticeEntity> page) {
        LambdaQueryWrapper<SeckillSkuNoticeEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSeckillSkuNotice(SeckillSkuNoticeEntity seckillSkuNoticeEntity) {
        return this.save(seckillSkuNoticeEntity);
    }

    @Override
    public Boolean removeSeckillSkuNoticeById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSeckillSkuNotice(SeckillSkuNoticeEntity seckillSkuNoticeEntity) {
        return this.updateById(seckillSkuNoticeEntity);
    }
}
