package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsMemberCollectSpuEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsMemberCollectSpuService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收藏的商品
 */
@Tag(name = "会员收藏的商品接口")
@RestController
@RequestMapping("/umsMemberCollectSpu")
@RequiredArgsConstructor
public class UmsMemberCollectSpuController {

    private final UmsMemberCollectSpuService umsMemberCollectSpuService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsMemberCollectSpuEntity>> page(
            Page<UmsMemberCollectSpuEntity> page
    ) {
        return CommonResult.success(umsMemberCollectSpuService.pageUmsMemberCollectSpus(page));
    }


    /**
     * 添加
     *
     * @param umsMemberCollectSpuEntity UmsMemberCollectSpuEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsMemberCollectSpuEntity umsMemberCollectSpuEntity) {
        return CommonResult.success(umsMemberCollectSpuService.saveUmsMemberCollectSpu(umsMemberCollectSpuEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsMemberCollectSpuService.removeUmsMemberCollectSpuById(id));
    }

    /**
     * 编辑
     *
     * @param umsMemberCollectSpuEntity UmsMemberCollectSpuEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsMemberCollectSpuEntity umsMemberCollectSpuEntity) {
        return CommonResult.success(umsMemberCollectSpuService.updateUmsMemberCollectSpu(umsMemberCollectSpuEntity));
    }
}
