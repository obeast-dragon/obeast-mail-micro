package com.obeast.product.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.product.api.dto.AttrGroupDTO;
import com.obeast.product.api.entity.AttrGroupEntity;
import com.obeast.product.biz.service.AttrAttrGroupRelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.AttrGroupMapper;
import com.obeast.product.biz.service.AttrGroupService;
import org.springframework.util.Assert;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 属性分组
 */
@Service("attrGroupService")
@RequiredArgsConstructor
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroupEntity> implements AttrGroupService {

    private final AttrAttrGroupRelService attrAttrGroupRelService;


    @Override
    public IPage<AttrGroupEntity> pageAttrGroups(Page<AttrGroupEntity> page, Long catelogId, String attrGroupName) {
        LambdaQueryWrapper<AttrGroupEntity> queryWrapper = Wrappers.lambdaQuery();
        if (catelogId != null){
            queryWrapper.eq(AttrGroupEntity::getCatelogId, catelogId);
        }
        if (StrUtil.isNotBlank(attrGroupName)) {
            queryWrapper.eq(AttrGroupEntity::getAttrGroupName, attrGroupName);
        }
        queryWrapper.orderByAsc(AttrGroupEntity::getSort);
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveAttrGroup(AttrGroupEntity attrGroupEntity) {
        return this.save(attrGroupEntity);
    }

    @Override
    public Boolean removeAttrGroupById(Long id) {
        return this.removeById(id);
    }


    @Override
    public List<AttrGroupDTO> listAttrGroupDTOByCateGory(Long catelogId) {
        return this.listAttrGroupByCateGory(catelogId).stream().map(item -> {
            AttrGroupDTO attrGroupDTO = new AttrGroupDTO();
            attrGroupDTO.setAttrGroup(item);
            attrGroupDTO.setAttrs(attrAttrGroupRelService.listAttrByAttrGroupId(item.getAttrGroupId()));
            return attrGroupDTO;
        }).toList();
    }


    @Override
    public List<AttrGroupEntity> listAttrGroupByCateGory(Long catelogId) {
        Assert.notNull(catelogId, "分类Id不能为空");
        LambdaQueryWrapper<AttrGroupEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AttrGroupEntity::getCatelogId, catelogId);
        return this.list(queryWrapper);
    }


    @Override
    public Boolean updateAttrGroup(AttrGroupEntity attrGroupEntity) {
        return this.updateById(attrGroupEntity);
    }
}
