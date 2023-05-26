package com.obeast.market.biz.controller;

import com.obeast.market.api.to.SkuReductionTo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.SkuFullReductionEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.SkuFullReductionService;

import javax.validation.Valid;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品满减信息
 */
@Tag(name = "商品满减信息接口")
@RestController
@RequestMapping("/skuFullReduction")
@RequiredArgsConstructor
public class SkuFullReductionController {

    private final SkuFullReductionService skuFullReductionService;

    /**
     * 分页查询
     *
     * @param page 分页对象
     */
    @GetMapping("/page")
    public CommonResult<IPage<SkuFullReductionEntity>> page(
            Page<SkuFullReductionEntity> page
    ) {
        return CommonResult.success(skuFullReductionService.pageSkuFullReductions(page));
    }


    /**
     * 添加
     *
     * @param skuFullReductionEntity SkuFullReductionEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody SkuFullReductionEntity skuFullReductionEntity) {
        return CommonResult.success(skuFullReductionService.saveSkuFullReduction(skuFullReductionEntity));
    }


    @PostMapping("/addInfo")
    public CommonResult<?> saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo) {
        return skuFullReductionService.saveSkuFullInfo(skuReductionTo);
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(skuFullReductionService.removeSkuFullReductionById(id));
    }

    /**
     * 编辑
     *
     * @param skuFullReductionEntity SkuFullReductionEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody SkuFullReductionEntity skuFullReductionEntity) {
        return CommonResult.success(skuFullReductionService.updateSkuFullReduction(skuFullReductionEntity));
    }
}
