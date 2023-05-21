package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.MemberReceiveAddressMapper;
import com.obeast.member.api.entity.MemberReceiveAddressEntity;
import com.obeast.member.biz.service.MemberReceiveAddressService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收货地址
 */
@Service("MemberReceiveAddressService")
public class MemberReceiveAddressServiceImpl extends ServiceImpl<MemberReceiveAddressMapper, MemberReceiveAddressEntity> implements MemberReceiveAddressService {

    @Override
    public IPage<MemberReceiveAddressEntity> pageMemberReceiveAddresss(Page<MemberReceiveAddressEntity> page) {
        LambdaQueryWrapper<MemberReceiveAddressEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMemberReceiveAddress(MemberReceiveAddressEntity memberReceiveAddressEntity) {
        return this.save(memberReceiveAddressEntity);
    }

    @Override
    public Boolean removeMemberReceiveAddressById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMemberReceiveAddress(MemberReceiveAddressEntity memberReceiveAddressEntity) {
        return this.updateById(memberReceiveAddressEntity);
    }
}
