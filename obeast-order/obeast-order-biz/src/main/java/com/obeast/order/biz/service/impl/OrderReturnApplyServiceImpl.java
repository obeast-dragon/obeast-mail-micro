package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.OrderReturnApplyMapper;
import com.obeast.order.api.entity.OrderReturnApplyEntity;
import com.obeast.order.biz.service.OrderReturnApplyService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单退货申请
 */
@Service("OrderReturnApplyService")
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyMapper, OrderReturnApplyEntity> implements OrderReturnApplyService {

    @Override
    public IPage<OrderReturnApplyEntity> pageOrderReturnApplys(Page<OrderReturnApplyEntity> page) {
        LambdaQueryWrapper<OrderReturnApplyEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveOrderReturnApply(OrderReturnApplyEntity orderReturnApplyEntity) {
        return this.save(orderReturnApplyEntity);
    }

    @Override
    public Boolean removeOrderReturnApplyById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateOrderReturnApply(OrderReturnApplyEntity orderReturnApplyEntity) {
        return this.updateById(orderReturnApplyEntity);
    }
}
