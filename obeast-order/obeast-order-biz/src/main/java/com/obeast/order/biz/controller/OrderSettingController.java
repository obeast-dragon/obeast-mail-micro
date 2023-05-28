package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.OrderSettingEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.OrderSettingService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单配置信息
 */
@Tag(name = "订单配置信息接口")
@RestController
@RequestMapping("/orderSetting")
@RequiredArgsConstructor
public class OrderSettingController {

    private final OrderSettingService orderSettingService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<OrderSettingEntity>> page(
            Page<OrderSettingEntity> page
    ) {
        return CommonResult.success(orderSettingService.pageOrderSettings(page));
    }


    /**
     * 添加
     *
     * @param orderSettingEntity OrderSettingEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody OrderSettingEntity orderSettingEntity) {
        return CommonResult.success(orderSettingService.saveOrderSetting(orderSettingEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(orderSettingService.removeOrderSettingById(id));
    }

    /**
     * 编辑
     *
     * @param orderSettingEntity OrderSettingEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody OrderSettingEntity orderSettingEntity) {
        return CommonResult.success(orderSettingService.updateOrderSetting(orderSettingEntity));
    }
}
