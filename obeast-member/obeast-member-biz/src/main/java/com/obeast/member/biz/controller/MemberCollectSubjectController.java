package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.MemberCollectSubjectEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.MemberCollectSubjectService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收藏的专题活动
 */
@Tag(name = "会员收藏的专题活动接口")
@RestController
@RequestMapping("/memberCollectSubject")
@RequiredArgsConstructor
public class MemberCollectSubjectController {

    private final MemberCollectSubjectService memberCollectSubjectService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<MemberCollectSubjectEntity>> page(
            Page<MemberCollectSubjectEntity> page
    ) {
        return CommonResult.success(memberCollectSubjectService.pageMemberCollectSubjects(page));
    }


    /**
     * 添加
     *
     * @param memberCollectSubjectEntity MemberCollectSubjectEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody MemberCollectSubjectEntity memberCollectSubjectEntity) {
        return CommonResult.success(memberCollectSubjectService.saveMemberCollectSubject(memberCollectSubjectEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(memberCollectSubjectService.removeMemberCollectSubjectById(id));
    }

    /**
     * 编辑
     *
     * @param memberCollectSubjectEntity MemberCollectSubjectEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody MemberCollectSubjectEntity memberCollectSubjectEntity) {
        return CommonResult.success(memberCollectSubjectService.updateMemberCollectSubject(memberCollectSubjectEntity));
    }
}
