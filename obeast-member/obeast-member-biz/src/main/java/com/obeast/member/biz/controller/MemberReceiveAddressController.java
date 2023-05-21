package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.MemberReceiveAddressEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.MemberReceiveAddressService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收货地址
 */
@Tag(name = "会员收货地址接口")
@RestController
@RequestMapping("/memberReceiveAddress")
@RequiredArgsConstructor
public class MemberReceiveAddressController {

    private final MemberReceiveAddressService memberReceiveAddressService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<MemberReceiveAddressEntity>> page(
            Page<MemberReceiveAddressEntity> page
    ) {
        return CommonResult.success(memberReceiveAddressService.pageMemberReceiveAddresss(page));
    }


    /**
     * 添加
     *
     * @param memberReceiveAddressEntity MemberReceiveAddressEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody MemberReceiveAddressEntity memberReceiveAddressEntity) {
        return CommonResult.success(memberReceiveAddressService.saveMemberReceiveAddress(memberReceiveAddressEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(memberReceiveAddressService.removeMemberReceiveAddressById(id));
    }

    /**
     * 编辑
     *
     * @param memberReceiveAddressEntity MemberReceiveAddressEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody MemberReceiveAddressEntity memberReceiveAddressEntity) {
        return CommonResult.success(memberReceiveAddressService.updateMemberReceiveAddress(memberReceiveAddressEntity));
    }
}
