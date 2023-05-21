package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.IntegrationChangeHistoryMapper;
import com.obeast.member.api.entity.IntegrationChangeHistoryEntity;
import com.obeast.member.biz.service.IntegrationChangeHistoryService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 积分变化历史记录
 */
@Service("IntegrationChangeHistoryService")
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryMapper, IntegrationChangeHistoryEntity> implements IntegrationChangeHistoryService {

    @Override
    public IPage<IntegrationChangeHistoryEntity> pageIntegrationChangeHistorys(Page<IntegrationChangeHistoryEntity> page) {
        LambdaQueryWrapper<IntegrationChangeHistoryEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveIntegrationChangeHistory(IntegrationChangeHistoryEntity integrationChangeHistoryEntity) {
        return this.save(integrationChangeHistoryEntity);
    }

    @Override
    public Boolean removeIntegrationChangeHistoryById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateIntegrationChangeHistory(IntegrationChangeHistoryEntity integrationChangeHistoryEntity) {
        return this.updateById(integrationChangeHistoryEntity);
    }
}
