package com.obeast.product.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.product.api.entity.AttrGroupEntity;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.AttrGroupMapper;
import com.obeast.product.api.entity.AttrGroupEntity;
import com.obeast.product.biz.service.AttrGroupService;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 属性分组
 */
@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroupEntity> implements AttrGroupService {

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
    public Boolean updateAttrGroup(AttrGroupEntity attrGroupEntity) {
        return this.updateById(attrGroupEntity);
    }
}
