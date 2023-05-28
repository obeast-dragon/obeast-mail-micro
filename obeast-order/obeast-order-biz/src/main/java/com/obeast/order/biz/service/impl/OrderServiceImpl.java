package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.OrderMapper;
import com.obeast.order.api.entity.OrderEntity;
import com.obeast.order.biz.service.OrderService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单
 */
@Service("OrderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

    @Override
    public IPage<OrderEntity> pageOrders(Page<OrderEntity> page) {
        LambdaQueryWrapper<OrderEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveOrder(OrderEntity orderEntity) {
        return this.save(orderEntity);
    }

    @Override
    public Boolean removeOrderById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateOrder(OrderEntity orderEntity) {
        return this.updateById(orderEntity);
    }
}
