package com.obeast.market.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.SpuBoundsEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.SpuBoundsService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品spu积分设置
 */
@Tag(name = "商品spu积分设置接口")
@RestController
@RequestMapping("/spuBounds")
@RequiredArgsConstructor
public class SpuBoundsController {

    private final SpuBoundsService spuBoundsService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<SpuBoundsEntity>> page(
            Page<SpuBoundsEntity> page
    ) {
        return CommonResult.success(spuBoundsService.pageSpuBounds(page));
    }


    /**
     * 添加
     *
     * @param spuBoundsEntity SpuBoundsEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody SpuBoundsEntity spuBoundsEntity) {
        return CommonResult.success(spuBoundsService.saveSpuBounds(spuBoundsEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(spuBoundsService.removeSpuBoundsById(id));
    }

    /**
     * 编辑
     *
     * @param spuBoundsEntity SpuBoundsEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody SpuBoundsEntity spuBoundsEntity) {
        return CommonResult.success(spuBoundsService.updateSpuBounds(spuBoundsEntity));
    }
}
