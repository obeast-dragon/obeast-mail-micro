package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsMemberCollectSubjectEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsMemberCollectSubjectService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收藏的专题活动
 */
@Tag(name = "会员收藏的专题活动接口")
@RestController
@RequestMapping("/umsMemberCollectSubject")
@RequiredArgsConstructor
public class UmsMemberCollectSubjectController {

    private final UmsMemberCollectSubjectService umsMemberCollectSubjectService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsMemberCollectSubjectEntity>> page(
            Page<UmsMemberCollectSubjectEntity> page
    ) {
        return CommonResult.success(umsMemberCollectSubjectService.pageUmsMemberCollectSubjects(page));
    }


    /**
     * 添加
     *
     * @param umsMemberCollectSubjectEntity UmsMemberCollectSubjectEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsMemberCollectSubjectEntity umsMemberCollectSubjectEntity) {
        return CommonResult.success(umsMemberCollectSubjectService.saveUmsMemberCollectSubject(umsMemberCollectSubjectEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsMemberCollectSubjectService.removeUmsMemberCollectSubjectById(id));
    }

    /**
     * 编辑
     *
     * @param umsMemberCollectSubjectEntity UmsMemberCollectSubjectEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsMemberCollectSubjectEntity umsMemberCollectSubjectEntity) {
        return CommonResult.success(umsMemberCollectSubjectService.updateUmsMemberCollectSubject(umsMemberCollectSubjectEntity));
    }
}
