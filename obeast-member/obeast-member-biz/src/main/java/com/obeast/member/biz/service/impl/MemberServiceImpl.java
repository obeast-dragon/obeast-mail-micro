package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.MemberMapper;
import com.obeast.member.api.entity.MemberEntity;
import com.obeast.member.biz.service.MemberService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员
 */
@Service("MemberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberService {

    @Override
    public IPage<MemberEntity> pageMembers(Page<MemberEntity> page) {
        LambdaQueryWrapper<MemberEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMember(MemberEntity memberEntity) {
        return this.save(memberEntity);
    }

    @Override
    public Boolean removeMemberById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMember(MemberEntity memberEntity) {
        return this.updateById(memberEntity);
    }
}
