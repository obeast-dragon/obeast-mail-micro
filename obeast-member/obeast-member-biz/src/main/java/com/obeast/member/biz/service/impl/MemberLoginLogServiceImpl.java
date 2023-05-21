package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.MemberLoginLogMapper;
import com.obeast.member.api.entity.MemberLoginLogEntity;
import com.obeast.member.biz.service.MemberLoginLogService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员登录记录
 */
@Service("MemberLoginLogService")
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLogEntity> implements MemberLoginLogService {

    @Override
    public IPage<MemberLoginLogEntity> pageMemberLoginLogs(Page<MemberLoginLogEntity> page) {
        LambdaQueryWrapper<MemberLoginLogEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMemberLoginLog(MemberLoginLogEntity memberLoginLogEntity) {
        return this.save(memberLoginLogEntity);
    }

    @Override
    public Boolean removeMemberLoginLogById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMemberLoginLog(MemberLoginLogEntity memberLoginLogEntity) {
        return this.updateById(memberLoginLogEntity);
    }
}
