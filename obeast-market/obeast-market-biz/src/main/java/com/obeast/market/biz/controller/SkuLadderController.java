package com.obeast.market.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.SkuLadderEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.SkuLadderService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品阶梯价格
 */
@Tag(name = "商品阶梯价格接口")
@RestController
@RequestMapping("/skuLadder")
@RequiredArgsConstructor
public class SkuLadderController {

    private final SkuLadderService skuLadderService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<SkuLadderEntity>> page(
            Page<SkuLadderEntity> page
    ) {
        return CommonResult.success(skuLadderService.pageSkuLadders(page));
    }


    /**
     * 添加
     *
     * @param skuLadderEntity SkuLadderEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody SkuLadderEntity skuLadderEntity) {
        return CommonResult.success(skuLadderService.saveSkuLadder(skuLadderEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(skuLadderService.removeSkuLadderById(id));
    }

    /**
     * 编辑
     *
     * @param skuLadderEntity SkuLadderEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody SkuLadderEntity skuLadderEntity) {
        return CommonResult.success(skuLadderService.updateSkuLadder(skuLadderEntity));
    }
}
