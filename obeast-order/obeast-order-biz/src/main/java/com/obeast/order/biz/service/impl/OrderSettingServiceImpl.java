package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.OrderSettingMapper;
import com.obeast.order.api.entity.OrderSettingEntity;
import com.obeast.order.biz.service.OrderSettingService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单配置信息
 */
@Service("OrderSettingService")
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSettingEntity> implements OrderSettingService {

    @Override
    public IPage<OrderSettingEntity> pageOrderSettings(Page<OrderSettingEntity> page) {
        LambdaQueryWrapper<OrderSettingEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveOrderSetting(OrderSettingEntity orderSettingEntity) {
        return this.save(orderSettingEntity);
    }

    @Override
    public Boolean removeOrderSettingById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateOrderSetting(OrderSettingEntity orderSettingEntity) {
        return this.updateById(orderSettingEntity);
    }
}
