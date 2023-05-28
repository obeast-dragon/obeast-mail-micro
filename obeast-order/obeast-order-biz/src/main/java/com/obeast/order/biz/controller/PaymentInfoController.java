package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.PaymentInfoEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.PaymentInfoService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 支付信息表
 */
@Tag(name = "支付信息表接口")
@RestController
@RequestMapping("/paymentInfo")
@RequiredArgsConstructor
public class PaymentInfoController {

    private final PaymentInfoService paymentInfoService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<PaymentInfoEntity>> page(
            Page<PaymentInfoEntity> page
    ) {
        return CommonResult.success(paymentInfoService.pagePaymentInfos(page));
    }


    /**
     * 添加
     *
     * @param paymentInfoEntity PaymentInfoEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody PaymentInfoEntity paymentInfoEntity) {
        return CommonResult.success(paymentInfoService.savePaymentInfo(paymentInfoEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(paymentInfoService.removePaymentInfoById(id));
    }

    /**
     * 编辑
     *
     * @param paymentInfoEntity PaymentInfoEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody PaymentInfoEntity paymentInfoEntity) {
        return CommonResult.success(paymentInfoService.updatePaymentInfo(paymentInfoEntity));
    }
}
