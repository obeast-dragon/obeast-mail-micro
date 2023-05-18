package com.obeast.product.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.AttrGroupService;



/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 属性分组
 */
@Tag(name = "属性分组接口")
@RestController
@RequestMapping("/attrGroup")
@RequiredArgsConstructor
public class AttrGroupController {

    private final AttrGroupService attrGroupService;

}
