package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsIntegrationChangeHistoryMapper;
import com.obeast.member.api.entity.UmsIntegrationChangeHistoryEntity;
import com.obeast.member.biz.service.UmsIntegrationChangeHistoryService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 积分变化历史记录
 */
@Service("UmsIntegrationChangeHistoryService")
public class UmsIntegrationChangeHistoryServiceImpl extends ServiceImpl<UmsIntegrationChangeHistoryMapper, UmsIntegrationChangeHistoryEntity> implements UmsIntegrationChangeHistoryService {

    @Override
    public IPage<UmsIntegrationChangeHistoryEntity> pageUmsIntegrationChangeHistorys(Page<UmsIntegrationChangeHistoryEntity> page) {
        LambdaQueryWrapper<UmsIntegrationChangeHistoryEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsIntegrationChangeHistory(UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistoryEntity) {
        return this.save(umsIntegrationChangeHistoryEntity);
    }

    @Override
    public Boolean removeUmsIntegrationChangeHistoryById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsIntegrationChangeHistory(UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistoryEntity) {
        return this.updateById(umsIntegrationChangeHistoryEntity);
    }
}
