package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.OrderOperateHistoryMapper;
import com.obeast.order.api.entity.OrderOperateHistoryEntity;
import com.obeast.order.biz.service.OrderOperateHistoryService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单操作历史记录
 */
@Service("OrderOperateHistoryService")
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistoryEntity> implements OrderOperateHistoryService {

    @Override
    public IPage<OrderOperateHistoryEntity> pageOrderOperateHistorys(Page<OrderOperateHistoryEntity> page) {
        LambdaQueryWrapper<OrderOperateHistoryEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveOrderOperateHistory(OrderOperateHistoryEntity orderOperateHistoryEntity) {
        return this.save(orderOperateHistoryEntity);
    }

    @Override
    public Boolean removeOrderOperateHistoryById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateOrderOperateHistory(OrderOperateHistoryEntity orderOperateHistoryEntity) {
        return this.updateById(orderOperateHistoryEntity);
    }
}
