package com.obeast.product.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.SkuInfoEntity;
import com.obeast.product.api.entity.SpuInfoEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.SkuInfoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku信息
 */
@Tag(name = "sku信息接口")
@RestController
@RequestMapping("/skuInfo")
@RequiredArgsConstructor
public class SkuInfoController {

    private final SkuInfoService skuInfoService;

    /**
     * 分页查询
     *
     * @param page   分页对象
     */
    @GetMapping("/page")
    public CommonResult<IPage<SkuInfoEntity>> page(
            Page<SkuInfoEntity> page,
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "brandId", required = false) Long brandId,
            @RequestParam(value = "priceMin", required = false) BigDecimal priceMin,
            @RequestParam(value = "priceMax", required = false) BigDecimal priceMax,
            @RequestParam(value = "skuName", required = false) String skuName
    ) {
        return CommonResult.success(skuInfoService.pageSkuInfo(page, categoryId, brandId, priceMin, priceMax , skuName));
    }


}
