package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsMemberStatisticsInfoMapper;
import com.obeast.member.api.entity.UmsMemberStatisticsInfoEntity;
import com.obeast.member.biz.service.UmsMemberStatisticsInfoService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员统计信息
 */
@Service("UmsMemberStatisticsInfoService")
public class UmsMemberStatisticsInfoServiceImpl extends ServiceImpl<UmsMemberStatisticsInfoMapper, UmsMemberStatisticsInfoEntity> implements UmsMemberStatisticsInfoService {

    @Override
    public IPage<UmsMemberStatisticsInfoEntity> pageUmsMemberStatisticsInfos(Page<UmsMemberStatisticsInfoEntity> page) {
        LambdaQueryWrapper<UmsMemberStatisticsInfoEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsMemberStatisticsInfo(UmsMemberStatisticsInfoEntity umsMemberStatisticsInfoEntity) {
        return this.save(umsMemberStatisticsInfoEntity);
    }

    @Override
    public Boolean removeUmsMemberStatisticsInfoById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsMemberStatisticsInfo(UmsMemberStatisticsInfoEntity umsMemberStatisticsInfoEntity) {
        return this.updateById(umsMemberStatisticsInfoEntity);
    }
}
