package com.obeast.product.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.SpuAttrValueService;



/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: spu属性值
 */
@Tag(name = "spu属性值接口")
@RestController
@RequestMapping("/spuAttrValue")
@RequiredArgsConstructor
public class SpuAttrValueController {

    private final SpuAttrValueService spuAttrValueService;

}
