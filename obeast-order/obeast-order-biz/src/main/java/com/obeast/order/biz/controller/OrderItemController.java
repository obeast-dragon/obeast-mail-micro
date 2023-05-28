package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.OrderItemEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.OrderItemService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单项信息
 */
@Tag(name = "订单项信息接口")
@RestController
@RequestMapping("/orderItem")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<OrderItemEntity>> page(
            Page<OrderItemEntity> page
    ) {
        return CommonResult.success(orderItemService.pageOrderItems(page));
    }


    /**
     * 添加
     *
     * @param orderItemEntity OrderItemEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody OrderItemEntity orderItemEntity) {
        return CommonResult.success(orderItemService.saveOrderItem(orderItemEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(orderItemService.removeOrderItemById(id));
    }

    /**
     * 编辑
     *
     * @param orderItemEntity OrderItemEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody OrderItemEntity orderItemEntity) {
        return CommonResult.success(orderItemService.updateOrderItem(orderItemEntity));
    }
}
