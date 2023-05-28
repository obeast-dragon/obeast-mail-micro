package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.OrderEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.OrderService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单
 */
@Tag(name = "订单接口")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<OrderEntity>> page(
            Page<OrderEntity> page
    ) {
        return CommonResult.success(orderService.pageOrders(page));
    }


    /**
     * 添加
     *
     * @param orderEntity OrderEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody OrderEntity orderEntity) {
        return CommonResult.success(orderService.saveOrder(orderEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(orderService.removeOrderById(id));
    }

    /**
     * 编辑
     *
     * @param orderEntity OrderEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody OrderEntity orderEntity) {
        return CommonResult.success(orderService.updateOrder(orderEntity));
    }
}
