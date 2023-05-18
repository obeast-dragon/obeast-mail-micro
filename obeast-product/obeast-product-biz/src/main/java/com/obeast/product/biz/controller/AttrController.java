package com.obeast.product.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.AttrService;



/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品属性
 */
@Tag(name = "商品属性接口")
@RestController
@RequestMapping("/attr")
@RequiredArgsConstructor
public class AttrController {

    private final AttrService attrService;

}
