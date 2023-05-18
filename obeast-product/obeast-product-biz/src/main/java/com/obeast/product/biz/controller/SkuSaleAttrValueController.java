package com.obeast.product.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.SkuSaleAttrValueService;



/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: sku销售属性值
 */
@Tag(name = "sku销售属性值接口")
@RestController
@RequestMapping("/skuSaleAttrValue")
@RequiredArgsConstructor
public class SkuSaleAttrValueController {

    private final SkuSaleAttrValueService skuSaleAttrValueService;

}
