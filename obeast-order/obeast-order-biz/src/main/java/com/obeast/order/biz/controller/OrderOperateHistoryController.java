package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.OrderOperateHistoryEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.OrderOperateHistoryService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单操作历史记录
 */
@Tag(name = "订单操作历史记录接口")
@RestController
@RequestMapping("/orderOperateHistory")
@RequiredArgsConstructor
public class OrderOperateHistoryController {

    private final OrderOperateHistoryService orderOperateHistoryService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<OrderOperateHistoryEntity>> page(
            Page<OrderOperateHistoryEntity> page
    ) {
        return CommonResult.success(orderOperateHistoryService.pageOrderOperateHistorys(page));
    }


    /**
     * 添加
     *
     * @param orderOperateHistoryEntity OrderOperateHistoryEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody OrderOperateHistoryEntity orderOperateHistoryEntity) {
        return CommonResult.success(orderOperateHistoryService.saveOrderOperateHistory(orderOperateHistoryEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(orderOperateHistoryService.removeOrderOperateHistoryById(id));
    }

    /**
     * 编辑
     *
     * @param orderOperateHistoryEntity OrderOperateHistoryEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody OrderOperateHistoryEntity orderOperateHistoryEntity) {
        return CommonResult.success(orderOperateHistoryService.updateOrderOperateHistory(orderOperateHistoryEntity));
    }
}
