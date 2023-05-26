package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.MemberPriceMapper;
import com.obeast.market.api.entity.MemberPriceEntity;
import com.obeast.market.biz.service.MemberPriceService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品会员价格
 */
@Service("MemberPriceService")
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceMapper, MemberPriceEntity> implements MemberPriceService {

    @Override
    public IPage<MemberPriceEntity> pageMemberPrices(Page<MemberPriceEntity> page) {
        LambdaQueryWrapper<MemberPriceEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMemberPrice(MemberPriceEntity memberPriceEntity) {
        return this.save(memberPriceEntity);
    }

    @Override
    public Boolean removeMemberPriceById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMemberPrice(MemberPriceEntity memberPriceEntity) {
        return this.updateById(memberPriceEntity);
    }
}
