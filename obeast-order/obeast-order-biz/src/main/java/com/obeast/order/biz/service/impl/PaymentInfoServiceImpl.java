package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.PaymentInfoMapper;
import com.obeast.order.api.entity.PaymentInfoEntity;
import com.obeast.order.biz.service.PaymentInfoService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 支付信息表
 */
@Service("PaymentInfoService")
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfoEntity> implements PaymentInfoService {

    @Override
    public IPage<PaymentInfoEntity> pagePaymentInfos(Page<PaymentInfoEntity> page) {
        LambdaQueryWrapper<PaymentInfoEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean savePaymentInfo(PaymentInfoEntity paymentInfoEntity) {
        return this.save(paymentInfoEntity);
    }

    @Override
    public Boolean removePaymentInfoById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updatePaymentInfo(PaymentInfoEntity paymentInfoEntity) {
        return this.updateById(paymentInfoEntity);
    }
}
