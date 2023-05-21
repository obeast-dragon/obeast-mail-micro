package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.MemberStatisticsInfoMapper;
import com.obeast.member.api.entity.MemberStatisticsInfoEntity;
import com.obeast.member.biz.service.MemberStatisticsInfoService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员统计信息
 */
@Service("MemberStatisticsInfoService")
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoMapper, MemberStatisticsInfoEntity> implements MemberStatisticsInfoService {

    @Override
    public IPage<MemberStatisticsInfoEntity> pageMemberStatisticsInfos(Page<MemberStatisticsInfoEntity> page) {
        LambdaQueryWrapper<MemberStatisticsInfoEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMemberStatisticsInfo(MemberStatisticsInfoEntity memberStatisticsInfoEntity) {
        return this.save(memberStatisticsInfoEntity);
    }

    @Override
    public Boolean removeMemberStatisticsInfoById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMemberStatisticsInfo(MemberStatisticsInfoEntity memberStatisticsInfoEntity) {
        return this.updateById(memberStatisticsInfoEntity);
    }
}
