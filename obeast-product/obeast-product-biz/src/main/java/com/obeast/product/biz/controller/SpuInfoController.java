package com.obeast.product.biz.controller;

import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.vo.SpuSaveVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obeast.product.biz.service.SpuInfoService;



/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: spu信息
 */
@Tag(name = "spu信息接口")
@RestController
@RequestMapping("/spuInfo")
@RequiredArgsConstructor
public class SpuInfoController {

    private final SpuInfoService spuInfoService;


    /**
     * 保存
     */
    @PostMapping("/save")
    public CommonResult<Boolean> save(@RequestBody SpuSaveVo spuSaveVo){
        return CommonResult.success(spuInfoService.saveSpuInfo(spuSaveVo));
    }

}
