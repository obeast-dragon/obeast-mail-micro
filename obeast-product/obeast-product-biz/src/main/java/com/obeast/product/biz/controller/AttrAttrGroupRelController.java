package com.obeast.product.biz.controller;

import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.dto.AttrAttrGroupRelsDTO;
import com.obeast.product.api.vo.AttrAttrGroupVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.obeast.product.biz.service.AttrAttrGroupRelService;

import javax.validation.Valid;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 属性&属性分组关联
 */
@Tag(name = "属性&属性分组关联接口")
@RestController
@RequestMapping("/attrAttrGroupRel")
@RequiredArgsConstructor
public class AttrAttrGroupRelController {

    private final AttrAttrGroupRelService attrAttrGroupRelService;

    /**
     * 查询关联
     */
    @GetMapping("/listRel")
    public CommonResult<List<AttrAttrGroupRelsDTO>> listRelsByBrandId(@RequestParam("attrGroupId") Long attrGroupId) {
        return CommonResult.success(attrAttrGroupRelService.listAttrDTOByAttrGroupId(attrGroupId));
    }


    /**
     * 编辑
     *
     * @param attrAttrGroupVo attrAttrGroupVo
     * @return success/false
     */
    @PutMapping("/updateRels")
    public CommonResult<Boolean> update(@Valid @RequestBody AttrAttrGroupVo attrAttrGroupVo) {
        return CommonResult.success(attrAttrGroupRelService.updateCategoryBrandRel(attrAttrGroupVo));
    }

}
