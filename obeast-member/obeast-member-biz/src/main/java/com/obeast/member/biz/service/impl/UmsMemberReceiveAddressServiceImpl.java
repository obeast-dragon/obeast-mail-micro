package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsMemberReceiveAddressMapper;
import com.obeast.member.api.entity.UmsMemberReceiveAddressEntity;
import com.obeast.member.biz.service.UmsMemberReceiveAddressService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收货地址
 */
@Service("UmsMemberReceiveAddressService")
public class UmsMemberReceiveAddressServiceImpl extends ServiceImpl<UmsMemberReceiveAddressMapper, UmsMemberReceiveAddressEntity> implements UmsMemberReceiveAddressService {

    @Override
    public IPage<UmsMemberReceiveAddressEntity> pageUmsMemberReceiveAddresss(Page<UmsMemberReceiveAddressEntity> page) {
        LambdaQueryWrapper<UmsMemberReceiveAddressEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsMemberReceiveAddress(UmsMemberReceiveAddressEntity umsMemberReceiveAddressEntity) {
        return this.save(umsMemberReceiveAddressEntity);
    }

    @Override
    public Boolean removeUmsMemberReceiveAddressById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsMemberReceiveAddress(UmsMemberReceiveAddressEntity umsMemberReceiveAddressEntity) {
        return this.updateById(umsMemberReceiveAddressEntity);
    }
}
