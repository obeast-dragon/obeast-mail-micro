package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.GrowthChangeHistoryMapper;
import com.obeast.member.api.entity.GrowthChangeHistoryEntity;
import com.obeast.member.biz.service.GrowthChangeHistoryService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 成长值变化历史记录
 */
@Service("GrowthChangeHistoryService")
public class GrowthChangeHistoryServiceImpl extends ServiceImpl<GrowthChangeHistoryMapper, GrowthChangeHistoryEntity> implements GrowthChangeHistoryService {

    @Override
    public IPage<GrowthChangeHistoryEntity> pageGrowthChangeHistorys(Page<GrowthChangeHistoryEntity> page) {
        LambdaQueryWrapper<GrowthChangeHistoryEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveGrowthChangeHistory(GrowthChangeHistoryEntity growthChangeHistoryEntity) {
        return this.save(growthChangeHistoryEntity);
    }

    @Override
    public Boolean removeGrowthChangeHistoryById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateGrowthChangeHistory(GrowthChangeHistoryEntity growthChangeHistoryEntity) {
        return this.updateById(growthChangeHistoryEntity);
    }
}
