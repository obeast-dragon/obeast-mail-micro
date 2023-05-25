package com.obeast.product.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.AttrMapper;
import com.obeast.product.api.entity.AttrEntity;
import com.obeast.product.biz.service.AttrService;
import org.springframework.util.Assert;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品属性
 */
@Service("attrService")
@RequiredArgsConstructor
public class AttrServiceImpl extends ServiceImpl<AttrMapper, AttrEntity> implements AttrService {


    @Override
    public IPage<AttrEntity> pageAttrs(Page<AttrEntity> page, String attrName, Integer valueType) {
        LambdaQueryWrapper<AttrEntity> queryWrapper = Wrappers.lambdaQuery();
        if (StrUtil.isNotBlank(attrName)) {
            queryWrapper.like(AttrEntity::getAttrName, attrName);
        }
        if (valueType != null && valueType != -1) {
            queryWrapper.eq(AttrEntity::getValueType, valueType);
        }
        queryWrapper.orderByAsc(AttrEntity::getSort);
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveAttr(AttrEntity attrEntity) {
        return this.save(attrEntity);
    }

    @Override
    public Boolean removeAttrById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateAttr(AttrEntity attrEntity) {
        return this.updateById(attrEntity);
    }

    @Override
    public List<AttrEntity> listAttrSaleListCategoryId(Long categoryId) {
        Assert.notNull(categoryId, "商品Id不能为空");
        LambdaQueryWrapper<AttrEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AttrEntity::getCatelogId, categoryId);
        queryWrapper.eq(AttrEntity::getAttrType, 0);
        return this.list(queryWrapper);
    }
}
