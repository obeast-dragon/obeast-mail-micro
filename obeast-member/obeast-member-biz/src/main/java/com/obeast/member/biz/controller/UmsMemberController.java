package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsMemberEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsMemberService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员
 */
@Tag(name = "会员接口")
@RestController
@RequestMapping("/umsMember")
@RequiredArgsConstructor
public class UmsMemberController {

    private final UmsMemberService umsMemberService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsMemberEntity>> page(
            Page<UmsMemberEntity> page
    ) {
        return CommonResult.success(umsMemberService.pageUmsMembers(page));
    }


    /**
     * 添加
     *
     * @param umsMemberEntity UmsMemberEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsMemberEntity umsMemberEntity) {
        return CommonResult.success(umsMemberService.saveUmsMember(umsMemberEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsMemberService.removeUmsMemberById(id));
    }

    /**
     * 编辑
     *
     * @param umsMemberEntity UmsMemberEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsMemberEntity umsMemberEntity) {
        return CommonResult.success(umsMemberService.updateUmsMember(umsMemberEntity));
    }
}
