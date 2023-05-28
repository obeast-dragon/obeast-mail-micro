package com.obeast.ware.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.ware.api.entity.WareInfoEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.biz.service.WareInfoService;

import javax.validation.Valid;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 仓库信息
 */
@Tag(name = "仓库信息接口")
@RestController
@RequestMapping("/wareInfo")
@RequiredArgsConstructor
public class WareInfoController {

    private final WareInfoService wareInfoService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<WareInfoEntity>> page(
            Page<WareInfoEntity> page,
            @RequestParam(value = "name", required = false) String name
    ) {
        return CommonResult.success(wareInfoService.pageWareInfos(page, name));
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public CommonResult<List<WareInfoEntity>> list() {
        return CommonResult.success(wareInfoService.listWareInfos());
    }


    /**
     * 添加
     *
     * @param wareInfoEntity WareInfoEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody WareInfoEntity wareInfoEntity) {
        return CommonResult.success(wareInfoService.saveWareInfo(wareInfoEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(wareInfoService.removeWareInfoById(id));
    }

    /**
     * 编辑
     *
     * @param wareInfoEntity WareInfoEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody WareInfoEntity wareInfoEntity) {
        return CommonResult.success(wareInfoService.updateWareInfo(wareInfoEntity));
    }
}
