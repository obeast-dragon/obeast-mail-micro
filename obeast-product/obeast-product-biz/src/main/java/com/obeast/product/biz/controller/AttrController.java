package com.obeast.product.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.AttrEntity;
import com.obeast.product.biz.service.AttrAttrGroupRelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.obeast.product.biz.service.AttrService;

import javax.validation.Valid;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品属性
 */
@Tag(name = "商品属性接口")
@RestController
@RequestMapping("/attr")
@RequiredArgsConstructor
public class AttrController {

    private final AttrService attrService;

    /**
     * 分页查询
     *
     * @param page   分页对象
     */
    @GetMapping("/page")
    public CommonResult<IPage<AttrEntity>> page(
            Page<AttrEntity> page,
            @RequestParam(value = "attrName", required = false) String attrName,
            @RequestParam(value = "valueType", required = false) Integer valueType
    ) {
        return CommonResult.success(attrService.pageAttrs(page, attrName, valueType));
    }

    @GetMapping("/sale/list/{categoryId}")
    public CommonResult<List<AttrEntity>> attrSaleListCategoryId (@PathVariable("categoryId") Long categoryId) {
        return CommonResult.success(attrService.listAttrSaleListCategoryId(categoryId));
    }

    /**
     * 添加
     *
     * @param attrEntity attrEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody AttrEntity attrEntity) {
        return CommonResult.success(attrService.saveAttr(attrEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(attrService.removeAttrById(id));
    }

    /**
     * 编辑
     *
     * @param attrEntity attrEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody AttrEntity attrEntity) {
        return CommonResult.success(attrService.updateAttr(attrEntity));
    }

}
