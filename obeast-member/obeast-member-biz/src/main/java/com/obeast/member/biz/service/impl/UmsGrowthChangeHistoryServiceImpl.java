package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsGrowthChangeHistoryMapper;
import com.obeast.member.api.entity.UmsGrowthChangeHistoryEntity;
import com.obeast.member.biz.service.UmsGrowthChangeHistoryService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 成长值变化历史记录
 */
@Service("UmsGrowthChangeHistoryService")
public class UmsGrowthChangeHistoryServiceImpl extends ServiceImpl<UmsGrowthChangeHistoryMapper, UmsGrowthChangeHistoryEntity> implements UmsGrowthChangeHistoryService {

    @Override
    public IPage<UmsGrowthChangeHistoryEntity> pageUmsGrowthChangeHistorys(Page<UmsGrowthChangeHistoryEntity> page) {
        LambdaQueryWrapper<UmsGrowthChangeHistoryEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsGrowthChangeHistory(UmsGrowthChangeHistoryEntity umsGrowthChangeHistoryEntity) {
        return this.save(umsGrowthChangeHistoryEntity);
    }

    @Override
    public Boolean removeUmsGrowthChangeHistoryById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsGrowthChangeHistory(UmsGrowthChangeHistoryEntity umsGrowthChangeHistoryEntity) {
        return this.updateById(umsGrowthChangeHistoryEntity);
    }
}
