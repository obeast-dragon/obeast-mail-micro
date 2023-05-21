package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.MemberCollectSubjectMapper;
import com.obeast.member.api.entity.MemberCollectSubjectEntity;
import com.obeast.member.biz.service.MemberCollectSubjectService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收藏的专题活动
 */
@Service("MemberCollectSubjectService")
public class MemberCollectSubjectServiceImpl extends ServiceImpl<MemberCollectSubjectMapper, MemberCollectSubjectEntity> implements MemberCollectSubjectService {

    @Override
    public IPage<MemberCollectSubjectEntity> pageMemberCollectSubjects(Page<MemberCollectSubjectEntity> page) {
        LambdaQueryWrapper<MemberCollectSubjectEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMemberCollectSubject(MemberCollectSubjectEntity memberCollectSubjectEntity) {
        return this.save(memberCollectSubjectEntity);
    }

    @Override
    public Boolean removeMemberCollectSubjectById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMemberCollectSubject(MemberCollectSubjectEntity memberCollectSubjectEntity) {
        return this.updateById(memberCollectSubjectEntity);
    }
}
