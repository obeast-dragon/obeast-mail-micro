package com.obeast.admin.biz.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.admin.api.entity.SysDict;
import com.obeast.admin.api.entity.SysDictItem;
import com.obeast.admin.biz.service.SysDictItemService;
import com.obeast.admin.biz.service.SysDictService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.CacheConstants;
import com.obeast.common.log.annotation.SysLogFlag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:15
 * @version 1.0
 * Description: 字典表 前端控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/dict")
@Tag(name = "字典管理模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class SysDictController {

	private final SysDictItemService sysDictItemService;

	private final SysDictService sysDictService;

	/**
	 * 通过ID查询字典信息
	 * @param id ID
	 * @return 字典信息
	 */
	@GetMapping("/{id:\\d+}")
	public CommonResult<SysDict> getById(@PathVariable Long id) {
		return CommonResult.success(sysDictService.getById(id));
	}

	/**
	 * 查询字典信息
	 * @return List对象
	 */
	@GetMapping("/list")
	public CommonResult<List<SysDict>> getDictPage(@RequestParam(value = "name", required = false) String name) {
		LambdaQueryWrapper<SysDict> lambdaQuery = Wrappers.lambdaQuery();
		if (StrUtil.isNotBlank(name)) {
			lambdaQuery.like(SysDict::getDescription, name);
		}
		return CommonResult.success(sysDictService.list(lambdaQuery));
	}

	/**
	 * 通过字典类型查找字典
	 * @param key 类型
	 * @return 同类型字典
	 */
	@GetMapping("/key/{key}")
	@Cacheable(value = CacheConstants.DICT_DETAILS, key = "#key")
	public CommonResult<List<SysDictItem>> getDictByKey(@PathVariable String key) {
		return CommonResult.success(sysDictItemService.list(Wrappers.<SysDictItem>query().lambda().eq(SysDictItem::getDictKey, key)));
	}

	/**
	 * 添加字典
	 * @param sysDict 字典信息
	 * @return success、false
	 */
	@SysLogFlag("添加字典")
	@PostMapping("/add")
	@PreAuthorize("@pms.hasPermission('sys_dict_add')")
	public CommonResult<Boolean> save(@Valid @RequestBody SysDict sysDict) {
		return CommonResult.success(sysDictService.save(sysDict));
	}

	/**
	 * 删除字典，并且清除字典缓存
	 * @param id ID
	 * @return R
	 */
	@SysLogFlag("删除字典")
	@DeleteMapping("/{id:\\d+}")
	@PreAuthorize("@pms.hasPermission('sys_dict_del')")
	public CommonResult<?> removeById(@PathVariable Long id) {
		sysDictService.removeDict(id);
		return CommonResult.success();
	}

	/**
	 * 修改字典
	 * @param sysDict 字典信息
	 * @return success/false
	 */
	@PutMapping("update")
	@SysLogFlag("修改字典")
	@PreAuthorize("@pms.hasPermission('sys_dict_edit')")
	public CommonResult<?> updateById(@Valid @RequestBody SysDict sysDict) {
		sysDictService.updateDict(sysDict);
		return CommonResult.success();
	}

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param dictId dictId
	 */
	@GetMapping("/item/page")
	public CommonResult<IPage<SysDictItem>> getSysDictItemPage(
			Page<SysDictItem> page,
			@RequestParam(value = "dictId", required = false) Integer dictId
	) {
		LambdaQueryWrapper<SysDictItem> lambdaQuery = Wrappers.lambdaQuery();
		if (dictId != null){
			lambdaQuery.eq(SysDictItem::getDictId, dictId);
			return CommonResult.success(sysDictItemService.page(page, lambdaQuery));
		}else {
			return CommonResult.success(new Page<>());
		}
	}

	/**
	 * 通过id查询字典项
	 * @param id id
	 * @return R
	 */
	@GetMapping("/item/{id:\\d+}")
	public CommonResult<SysDictItem> getDictItemById(@PathVariable("id") Long id) {
		return CommonResult.success(sysDictItemService.getById(id));
	}

	/**
	 * 新增字典项
	 * @param sysDictItem 字典项
	 * @return R
	 */
	@SysLogFlag("新增字典项")
	@PostMapping("/item/add")
	@CacheEvict(value = CacheConstants.DICT_DETAILS, allEntries = true)
	public CommonResult<Boolean> save(@RequestBody SysDictItem sysDictItem) {
		return CommonResult.success(sysDictItemService.save(sysDictItem));
	}

	/**
	 * 修改字典项
	 * @param sysDictItem 字典项
	 * @return R
	 */
	@SysLogFlag("修改字典项")
	@PutMapping("/item/update")
	public CommonResult<?> updateById(@RequestBody SysDictItem sysDictItem) {
		sysDictItemService.updateDictItem(sysDictItem);
		return CommonResult.success();
	}

	/**
	 * 通过id删除字典项
	 * @param id id
	 * @return R
	 */
	@SysLogFlag("删除字典项")
	@DeleteMapping("/item/{id:\\d+}")
	public CommonResult<?> removeDictItemById(@PathVariable Long id) {
		sysDictItemService.removeDictItem(id);
		return CommonResult.success();
	}

	@SysLogFlag("清除字典缓存")
	@DeleteMapping("/cache")
	@PreAuthorize("@pms.hasPermission('sys_dict_del')")
	public CommonResult<?> clearDictCache() {
		sysDictService.clearDictCache();
		return CommonResult.success();
	}

}
