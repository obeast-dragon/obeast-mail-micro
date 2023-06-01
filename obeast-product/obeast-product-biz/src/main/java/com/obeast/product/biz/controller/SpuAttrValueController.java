package com.obeast.product.biz.controller;

import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.SpuAttrValueEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.SpuAttrValueService;

import java.util.List;


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

    @GetMapping("/listBySpuId")
    public CommonResult<List<SpuAttrValueEntity>> listBySpuId (@RequestParam("spuId") Long spuId) {
        return  CommonResult.success(spuAttrValueService.listBySpuId(spuId));
    }

}
