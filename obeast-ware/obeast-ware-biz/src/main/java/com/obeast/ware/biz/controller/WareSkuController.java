package com.obeast.ware.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.ware.api.entity.WareSkuEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.biz.service.WareSkuService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 商品库存
 */
@Tag(name = "商品库存接口")
@RestController
@RequestMapping("/wareSku")
@RequiredArgsConstructor
public class WareSkuController {

    private final WareSkuService wareSkuService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<WareSkuEntity>> page(
            Page<WareSkuEntity> page
    ) {
        return CommonResult.success(wareSkuService.pageWareSkus(page));
    }


    /**
     * 添加
     *
     * @param wareSkuEntity WareSkuEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody WareSkuEntity wareSkuEntity) {
        return CommonResult.success(wareSkuService.saveWareSku(wareSkuEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(wareSkuService.removeWareSkuById(id));
    }

    /**
     * 编辑
     *
     * @param wareSkuEntity WareSkuEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody WareSkuEntity wareSkuEntity) {
        return CommonResult.success(wareSkuService.updateWareSku(wareSkuEntity));
    }
}
