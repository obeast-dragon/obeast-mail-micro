package com.obeast.ware.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.ware.api.entity.PurchaseEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.biz.service.PurchaseService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购信息
 */
@Tag(name = "采购信息接口")
@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<PurchaseEntity>> page(
            Page<PurchaseEntity> page
    ) {
        return CommonResult.success(purchaseService.pagePurchases(page));
    }


    /**
     * 添加
     *
     * @param purchaseEntity PurchaseEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody PurchaseEntity purchaseEntity) {
        return CommonResult.success(purchaseService.savePurchase(purchaseEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(purchaseService.removePurchaseById(id));
    }

    /**
     * 编辑
     *
     * @param purchaseEntity PurchaseEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody PurchaseEntity purchaseEntity) {
        return CommonResult.success(purchaseService.updatePurchase(purchaseEntity));
    }
}
