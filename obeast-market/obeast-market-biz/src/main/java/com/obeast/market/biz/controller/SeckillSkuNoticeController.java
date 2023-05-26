package com.obeast.market.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.SeckillSkuNoticeEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.SeckillSkuNoticeService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀商品通知订阅
 */
@Tag(name = "秒杀商品通知订阅接口")
@RestController
@RequestMapping("/seckillSkuNotice")
@RequiredArgsConstructor
public class SeckillSkuNoticeController {

    private final SeckillSkuNoticeService seckillSkuNoticeService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<SeckillSkuNoticeEntity>> page(
            Page<SeckillSkuNoticeEntity> page
    ) {
        return CommonResult.success(seckillSkuNoticeService.pageSeckillSkuNotices(page));
    }


    /**
     * 添加
     *
     * @param seckillSkuNoticeEntity SeckillSkuNoticeEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody SeckillSkuNoticeEntity seckillSkuNoticeEntity) {
        return CommonResult.success(seckillSkuNoticeService.saveSeckillSkuNotice(seckillSkuNoticeEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(seckillSkuNoticeService.removeSeckillSkuNoticeById(id));
    }

    /**
     * 编辑
     *
     * @param seckillSkuNoticeEntity SeckillSkuNoticeEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody SeckillSkuNoticeEntity seckillSkuNoticeEntity) {
        return CommonResult.success(seckillSkuNoticeService.updateSeckillSkuNotice(seckillSkuNoticeEntity));
    }
}
