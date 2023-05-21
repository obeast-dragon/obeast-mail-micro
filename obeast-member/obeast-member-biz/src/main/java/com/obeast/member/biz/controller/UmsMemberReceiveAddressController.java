package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsMemberReceiveAddressEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsMemberReceiveAddressService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收货地址
 */
@Tag(name = "会员收货地址接口")
@RestController
@RequestMapping("/umsMemberReceiveAddress")
@RequiredArgsConstructor
public class UmsMemberReceiveAddressController {

    private final UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsMemberReceiveAddressEntity>> page(
            Page<UmsMemberReceiveAddressEntity> page
    ) {
        return CommonResult.success(umsMemberReceiveAddressService.pageUmsMemberReceiveAddresss(page));
    }


    /**
     * 添加
     *
     * @param umsMemberReceiveAddressEntity UmsMemberReceiveAddressEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsMemberReceiveAddressEntity umsMemberReceiveAddressEntity) {
        return CommonResult.success(umsMemberReceiveAddressService.saveUmsMemberReceiveAddress(umsMemberReceiveAddressEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsMemberReceiveAddressService.removeUmsMemberReceiveAddressById(id));
    }

    /**
     * 编辑
     *
     * @param umsMemberReceiveAddressEntity UmsMemberReceiveAddressEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsMemberReceiveAddressEntity umsMemberReceiveAddressEntity) {
        return CommonResult.success(umsMemberReceiveAddressService.updateUmsMemberReceiveAddress(umsMemberReceiveAddressEntity));
    }
}
