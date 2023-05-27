package com.obeast.product.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.AttrEntity;
import com.obeast.product.api.entity.SpuInfoEntity;
import com.obeast.product.api.vo.SpuSaveVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

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
     * 分页查询
     *
     * @param page   分页对象
     */
    @GetMapping("/page")
    public CommonResult<IPage<SpuInfoEntity>> page(
            Page<SpuInfoEntity> page,
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "brandId", required = false) Long brandId,
            @RequestParam(value = "publishStatus", required = false) Integer publishStatus,
            @RequestParam(value = "spuName", required = false) String spuName
    ) {
        return CommonResult.success(spuInfoService.pageSpuInfo(page, categoryId, brandId, publishStatus, spuName));
    }

    /**
     * 保存
     */
    @PostMapping("/add")
    public CommonResult<?> save(@RequestBody SpuSaveVo spuSaveVo){
        return CommonResult.success(spuInfoService.saveSpuInfo(spuSaveVo));
    }

    /**
     * 保存
     */
    @PutMapping("/update/publishStatus/{spuInfoId}/{status}")
    public CommonResult<?> updatePublishStatus(@PathVariable("spuInfoId") Long spuInfoId,
                                               @PathVariable("status") Integer status){
        return CommonResult.success(spuInfoService.updatePublishStatus(spuInfoId, status));
    }

}
