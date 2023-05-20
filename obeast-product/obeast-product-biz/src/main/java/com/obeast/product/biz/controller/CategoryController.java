package com.obeast.product.biz.controller;

import cn.hutool.core.lang.tree.Tree;
import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.CategoryEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.obeast.product.biz.service.CategoryService;

import javax.validation.Valid;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品三级分类
 */
@Tag(name = "商品三级分类接口")
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * 返回树形商品分类集合
     * @param parentId 父节点ID
     * @return 树形菜单
     */
    @GetMapping(value = "/tree")
    public CommonResult<List<Tree<Long>>> getTree(
            @RequestParam(value = "parentId", required = false) Long parentId,
            @RequestParam(value = "name", required = false) String name
    ) {
        return CommonResult.success(categoryService.treeCategory(parentId, name));
    }

    /**
     * 添加
     * @param categoryEntity categoryEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody CategoryEntity categoryEntity) {
        return CommonResult.success(categoryService.saveCategory(categoryEntity));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(categoryService.removeCategoryById(id));
    }

    /**
     * 编辑
     * @param categoryEntity 实体
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody CategoryEntity categoryEntity) {
        return CommonResult.success(categoryService.updateCategory(categoryEntity));
    }


}
