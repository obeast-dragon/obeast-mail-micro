package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsMemberMapper;
import com.obeast.member.api.entity.UmsMemberEntity;
import com.obeast.member.biz.service.UmsMemberService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员
 */
@Service("UmsMemberService")
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMemberEntity> implements UmsMemberService {

    @Override
    public IPage<UmsMemberEntity> pageUmsMembers(Page<UmsMemberEntity> page) {
        LambdaQueryWrapper<UmsMemberEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsMember(UmsMemberEntity umsMemberEntity) {
        return this.save(umsMemberEntity);
    }

    @Override
    public Boolean removeUmsMemberById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsMember(UmsMemberEntity umsMemberEntity) {
        return this.updateById(umsMemberEntity);
    }
}
