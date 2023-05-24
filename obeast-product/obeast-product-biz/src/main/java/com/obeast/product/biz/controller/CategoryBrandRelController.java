package com.obeast.product.biz.controller;

import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.BrandEntity;
import com.obeast.product.api.entity.CategoryBrandRelEntity;
import com.obeast.product.api.vo.CategoryBrandRelVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.obeast.product.biz.service.CategoryBrandRelService;

import javax.validation.Valid;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌分类关联
 */
@Tag(name = "品牌分类关联接口")
@RestController
@RequestMapping("/categoryBrandRel")
@RequiredArgsConstructor
public class CategoryBrandRelController {

    private final CategoryBrandRelService categoryBrandRelService;

    /**
     * 查询关联
     */
    @GetMapping("/listRel")
    public CommonResult<List<CategoryBrandRelEntity>> listRelsByBrandId(@RequestParam("brandId") Long brandId) {
        return CommonResult.success(categoryBrandRelService.listRelsByBrandId(brandId));
    }

    /**
     * 查询关联
     */
    @GetMapping("/listRel/category/{categoryId}")
    public CommonResult<List<CategoryBrandRelEntity>> listRelsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return CommonResult.success(categoryBrandRelService.listRelsByCategoryId(categoryId));
    }


    /**
     * 添加
     *
     * @param categoryBrandRelEntity categoryBrandRelEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody CategoryBrandRelEntity categoryBrandRelEntity) {
        return CommonResult.success(categoryBrandRelService.saveCategoryBrandRel(categoryBrandRelEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(categoryBrandRelService.removeCategoryBrandRelById(id));
    }

    /**
     * 编辑
     *
     * @param categoryBrandRelVo categoryBrandRelVo
     * @return success/false
     */
    @PutMapping("/updateRels")
    public CommonResult<Boolean> update(@Valid @RequestBody CategoryBrandRelVo categoryBrandRelVo) {
        return CommonResult.success(categoryBrandRelService.updateCategoryBrandRel(categoryBrandRelVo));
    }
}
