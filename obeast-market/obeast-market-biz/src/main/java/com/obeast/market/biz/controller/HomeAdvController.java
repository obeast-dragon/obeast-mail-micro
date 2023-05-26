package com.obeast.market.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.HomeAdvEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.HomeAdvService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 首页轮播广告
 */
@Tag(name = "首页轮播广告接口")
@RestController
@RequestMapping("/homeAdv")
@RequiredArgsConstructor
public class HomeAdvController {

    private final HomeAdvService homeAdvService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<HomeAdvEntity>> page(
            Page<HomeAdvEntity> page
    ) {
        return CommonResult.success(homeAdvService.pageHomeAdvs(page));
    }


    /**
     * 添加
     *
     * @param homeAdvEntity HomeAdvEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody HomeAdvEntity homeAdvEntity) {
        return CommonResult.success(homeAdvService.saveHomeAdv(homeAdvEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(homeAdvService.removeHomeAdvById(id));
    }

    /**
     * 编辑
     *
     * @param homeAdvEntity HomeAdvEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody HomeAdvEntity homeAdvEntity) {
        return CommonResult.success(homeAdvService.updateHomeAdv(homeAdvEntity));
    }
}
