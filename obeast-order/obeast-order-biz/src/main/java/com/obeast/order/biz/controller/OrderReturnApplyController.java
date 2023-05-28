package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.OrderReturnApplyEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.OrderReturnApplyService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单退货申请
 */
@Tag(name = "订单退货申请接口")
@RestController
@RequestMapping("/orderReturnApply")
@RequiredArgsConstructor
public class OrderReturnApplyController {

    private final OrderReturnApplyService orderReturnApplyService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<OrderReturnApplyEntity>> page(
            Page<OrderReturnApplyEntity> page
    ) {
        return CommonResult.success(orderReturnApplyService.pageOrderReturnApplys(page));
    }


    /**
     * 添加
     *
     * @param orderReturnApplyEntity OrderReturnApplyEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody OrderReturnApplyEntity orderReturnApplyEntity) {
        return CommonResult.success(orderReturnApplyService.saveOrderReturnApply(orderReturnApplyEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(orderReturnApplyService.removeOrderReturnApplyById(id));
    }

    /**
     * 编辑
     *
     * @param orderReturnApplyEntity OrderReturnApplyEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody OrderReturnApplyEntity orderReturnApplyEntity) {
        return CommonResult.success(orderReturnApplyService.updateOrderReturnApply(orderReturnApplyEntity));
    }
}
