package com.obeast.product.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.CategoryBrandRelService;



/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌分类关联
 */
@Tag(name = "品牌分类关联接口")
@RestController
@RequestMapping("/categoryBrandRel")
@RequiredArgsConstructor
public class CategoryBrandRelController {

    private final CategoryBrandRelService categoryBrandRelService;

}
