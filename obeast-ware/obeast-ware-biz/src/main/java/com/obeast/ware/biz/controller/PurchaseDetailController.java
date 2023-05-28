package com.obeast.ware.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.ware.api.entity.PurchaseDetailEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.biz.service.PurchaseDetailService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购单
 */
@Tag(name = "采购单接口")
@RestController
@RequestMapping("/purchaseDetail")
@RequiredArgsConstructor
public class PurchaseDetailController {

    private final PurchaseDetailService purchaseDetailService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<PurchaseDetailEntity>> page(
            Page<PurchaseDetailEntity> page
    ) {
        return CommonResult.success(purchaseDetailService.pagePurchaseDetails(page));
    }


    /**
     * 添加
     *
     * @param purchaseDetailEntity PurchaseDetailEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody PurchaseDetailEntity purchaseDetailEntity) {
        return CommonResult.success(purchaseDetailService.savePurchaseDetail(purchaseDetailEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(purchaseDetailService.removePurchaseDetailById(id));
    }

    /**
     * 编辑
     *
     * @param purchaseDetailEntity PurchaseDetailEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody PurchaseDetailEntity purchaseDetailEntity) {
        return CommonResult.success(purchaseDetailService.updatePurchaseDetail(purchaseDetailEntity));
    }
}
