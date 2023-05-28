package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.OrderReturnReasonMapper;
import com.obeast.order.api.entity.OrderReturnReasonEntity;
import com.obeast.order.biz.service.OrderReturnReasonService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 退货原因
 */
@Service("OrderReturnReasonService")
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReasonEntity> implements OrderReturnReasonService {

    @Override
    public IPage<OrderReturnReasonEntity> pageOrderReturnReasons(Page<OrderReturnReasonEntity> page) {
        LambdaQueryWrapper<OrderReturnReasonEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveOrderReturnReason(OrderReturnReasonEntity orderReturnReasonEntity) {
        return this.save(orderReturnReasonEntity);
    }

    @Override
    public Boolean removeOrderReturnReasonById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateOrderReturnReason(OrderReturnReasonEntity orderReturnReasonEntity) {
        return this.updateById(orderReturnReasonEntity);
    }
}
