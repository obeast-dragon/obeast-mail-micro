package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.OrderItemMapper;
import com.obeast.order.api.entity.OrderItemEntity;
import com.obeast.order.biz.service.OrderItemService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单项信息
 */
@Service("OrderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements OrderItemService {

    @Override
    public IPage<OrderItemEntity> pageOrderItems(Page<OrderItemEntity> page) {
        LambdaQueryWrapper<OrderItemEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveOrderItem(OrderItemEntity orderItemEntity) {
        return this.save(orderItemEntity);
    }

    @Override
    public Boolean removeOrderItemById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateOrderItem(OrderItemEntity orderItemEntity) {
        return this.updateById(orderItemEntity);
    }
}
