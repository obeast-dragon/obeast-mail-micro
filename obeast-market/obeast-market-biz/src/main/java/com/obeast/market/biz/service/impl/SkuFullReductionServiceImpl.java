package com.obeast.market.biz.service.impl;

import com.obeast.market.api.entity.MemberPriceEntity;
import com.obeast.market.api.entity.SkuLadderEntity;
import com.obeast.market.api.to.SkuReductionTo;
import com.obeast.market.api.vo.MemberPrice;
import com.obeast.market.biz.service.MemberPriceService;
import com.obeast.market.biz.service.SkuLadderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.SkuFullReductionMapper;
import com.obeast.market.api.entity.SkuFullReductionEntity;
import com.obeast.market.biz.service.SkuFullReductionService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品满减信息
 */
@Service("SkuFullReductionService")
@RequiredArgsConstructor
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionMapper, SkuFullReductionEntity> implements SkuFullReductionService {

    private final SkuLadderService skuLadderService;

    private final MemberPriceService memberPriceService;

    @Override
    public IPage<SkuFullReductionEntity> pageSkuFullReductions(Page<SkuFullReductionEntity> page) {
        LambdaQueryWrapper<SkuFullReductionEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSkuFullReduction(SkuFullReductionEntity skuFullReductionEntity) {
        return this.save(skuFullReductionEntity);
    }

    @Override
    public Boolean removeSkuFullReductionById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean saveSkuFullInfo(SkuReductionTo skuReductionTo) {
        //sku的满减信息；beastmail_sms----》sms_sku_ladder、sms_sku_full_reduction\member_price
        //1、满减sms_sku_ladder阶梯价格
        SkuLadderEntity skuLadder = new SkuLadderEntity();
        skuLadder.setSkuId(skuReductionTo.getSkuId());
        skuLadder.setAddOther(skuReductionTo.getCountStatus());
        skuLadder.setFullCount(skuReductionTo.getFullCount());
        skuLadder.setDiscount(skuReductionTo.getDiscount());
        if(skuLadder.getFullCount() > 0){
            skuLadderService.save(skuLadder);

        }

        //2、sms_sku_full_reduction
        SkuFullReductionEntity skuFullReductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReductionTo, skuFullReductionEntity);
        if (skuFullReductionEntity.getFullPrice().compareTo(new BigDecimal("0")) == 1){
            this.save(skuFullReductionEntity);

        }

        //3、member_price
        List<MemberPrice> memberPrice = skuReductionTo.getMemberPrice();
        List<MemberPriceEntity> memberPrices = memberPrice.stream().map(item -> {
            MemberPriceEntity memberPriceEntity = new MemberPriceEntity();
            memberPriceEntity.setSkuId(skuReductionTo.getSkuId());
            memberPriceEntity.setMemberLevelId(item.getId());
            memberPriceEntity.setMemberLevelName(item.getName());
            memberPriceEntity.setMemberPrice(item.getPrice());
            memberPriceEntity.setAddOther(1);
            return memberPriceEntity;
        }).filter(item -> item.getMemberPrice().compareTo(new BigDecimal("0")) == 1).toList();

        memberPriceService.saveBatch(memberPrices);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateSkuFullReduction(SkuFullReductionEntity skuFullReductionEntity) {
        return this.updateById(skuFullReductionEntity);
    }
}
