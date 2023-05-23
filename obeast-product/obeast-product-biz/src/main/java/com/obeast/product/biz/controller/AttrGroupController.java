package com.obeast.product.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.AttrGroupEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.obeast.product.biz.service.AttrGroupService;

import javax.validation.Valid;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 属性分组
 */
@Tag(name = "属性分组接口")
@RestController
@RequestMapping("/attrGroup")
@RequiredArgsConstructor
public class AttrGroupController {

    private final AttrGroupService attrGroupService;

    /**
     * 分页查询
     *
     * @param page   分页对象
     */
    @GetMapping("/page")
    public CommonResult<IPage<AttrGroupEntity>> page(
            Page<AttrGroupEntity> page,
            @RequestParam(value = "catelogId", required = false) Long catelogId,
            @RequestParam(value = "attrGroupName", required = false) String attrGroupName
    ) {
        return CommonResult.success(attrGroupService.pageAttrGroups(page, catelogId, attrGroupName));
    }


    /**
     * 添加
     *
     * @param attrGroupEntity attrGroupEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody AttrGroupEntity attrGroupEntity) {
        return CommonResult.success(attrGroupService.saveAttrGroup(attrGroupEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(attrGroupService.removeAttrGroupById(id));
    }

    /**
     * 编辑
     *
     * @param attrGroupEntity attrGroupEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody AttrGroupEntity attrGroupEntity) {
        return CommonResult.success(attrGroupService.updateAttrGroup(attrGroupEntity));
    }
}
