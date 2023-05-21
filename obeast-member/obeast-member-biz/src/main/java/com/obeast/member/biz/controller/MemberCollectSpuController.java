package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.MemberCollectSpuEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.MemberCollectSpuService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收藏的商品
 */
@Tag(name = "会员收藏的商品接口")
@RestController
@RequestMapping("/memberCollectSpu")
@RequiredArgsConstructor
public class MemberCollectSpuController {

    private final MemberCollectSpuService memberCollectSpuService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<MemberCollectSpuEntity>> page(
            Page<MemberCollectSpuEntity> page
    ) {
        return CommonResult.success(memberCollectSpuService.pageMemberCollectSpus(page));
    }


    /**
     * 添加
     *
     * @param memberCollectSpuEntity MemberCollectSpuEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody MemberCollectSpuEntity memberCollectSpuEntity) {
        return CommonResult.success(memberCollectSpuService.saveMemberCollectSpu(memberCollectSpuEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(memberCollectSpuService.removeMemberCollectSpuById(id));
    }

    /**
     * 编辑
     *
     * @param memberCollectSpuEntity MemberCollectSpuEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody MemberCollectSpuEntity memberCollectSpuEntity) {
        return CommonResult.success(memberCollectSpuService.updateMemberCollectSpu(memberCollectSpuEntity));
    }
}
