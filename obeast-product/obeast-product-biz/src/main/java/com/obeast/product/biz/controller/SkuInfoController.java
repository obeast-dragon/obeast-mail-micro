package com.obeast.product.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.SkuInfoService;



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

}
