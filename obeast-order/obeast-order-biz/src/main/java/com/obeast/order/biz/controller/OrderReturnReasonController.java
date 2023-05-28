package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.OrderReturnReasonEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.OrderReturnReasonService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 退货原因
 */
@Tag(name = "退货原因接口")
@RestController
@RequestMapping("/orderReturnReason")
@RequiredArgsConstructor
public class OrderReturnReasonController {

    private final OrderReturnReasonService orderReturnReasonService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<OrderReturnReasonEntity>> page(
            Page<OrderReturnReasonEntity> page
    ) {
        return CommonResult.success(orderReturnReasonService.pageOrderReturnReasons(page));
    }


    /**
     * 添加
     *
     * @param orderReturnReasonEntity OrderReturnReasonEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody OrderReturnReasonEntity orderReturnReasonEntity) {
        return CommonResult.success(orderReturnReasonService.saveOrderReturnReason(orderReturnReasonEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(orderReturnReasonService.removeOrderReturnReasonById(id));
    }

    /**
     * 编辑
     *
     * @param orderReturnReasonEntity OrderReturnReasonEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody OrderReturnReasonEntity orderReturnReasonEntity) {
        return CommonResult.success(orderReturnReasonService.updateOrderReturnReason(orderReturnReasonEntity));
    }
}
