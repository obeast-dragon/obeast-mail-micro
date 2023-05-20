package com.obeast.product.biz.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.admin.api.entity.SysDict;
import com.obeast.admin.api.entity.SysDictItem;
import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.BrandEntity;
import com.obeast.product.api.entity.CategoryEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.obeast.product.biz.service.BrandService;

import javax.validation.Valid;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌
 */
@Tag(name = "品牌接口")
@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    /**
     * 分页查询
     *
     * @param page   分页对象
     * @param dictId dictId
     */
    @GetMapping("/page")
    public CommonResult<IPage<BrandEntity>> getSysDictItemPage(
            Page<BrandEntity> page,
            @RequestParam(value = "dictId", required = false) Integer dictId
    ) {
        return CommonResult.success(brandService.pageBrands(page));
    }


    /**
     * 添加
     *
     * @param brandEntity brandEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody BrandEntity brandEntity) {
        return CommonResult.success(brandService.saveBrand(brandEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(brandService.removeBrandById(id));
    }

    /**
     * 编辑
     *
     * @param brandEntity brandEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody BrandEntity brandEntity) {
        return CommonResult.success(brandService.updateBrand(brandEntity));
    }

}
