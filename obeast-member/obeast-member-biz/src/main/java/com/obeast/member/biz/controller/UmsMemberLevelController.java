package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsMemberLevelEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsMemberLevelService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员等级
 */
@Tag(name = "会员等级接口")
@RestController
@RequestMapping("/umsMemberLevel")
@RequiredArgsConstructor
public class UmsMemberLevelController {

    private final UmsMemberLevelService umsMemberLevelService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsMemberLevelEntity>> page(
            Page<UmsMemberLevelEntity> page
    ) {
        return CommonResult.success(umsMemberLevelService.pageUmsMemberLevels(page));
    }


    /**
     * 添加
     *
     * @param umsMemberLevelEntity UmsMemberLevelEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsMemberLevelEntity umsMemberLevelEntity) {
        return CommonResult.success(umsMemberLevelService.saveUmsMemberLevel(umsMemberLevelEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsMemberLevelService.removeUmsMemberLevelById(id));
    }

    /**
     * 编辑
     *
     * @param umsMemberLevelEntity UmsMemberLevelEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsMemberLevelEntity umsMemberLevelEntity) {
        return CommonResult.success(umsMemberLevelService.updateUmsMemberLevel(umsMemberLevelEntity));
    }
}
