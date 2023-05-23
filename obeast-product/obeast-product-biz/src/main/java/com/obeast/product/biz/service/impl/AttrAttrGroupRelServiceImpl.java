package com.obeast.product.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.product.api.dto.AttrAttrGroupDTO;
import com.obeast.product.api.entity.AttrEntity;
import com.obeast.product.api.vo.AttrAttrGroupVo;
import com.obeast.product.biz.service.AttrService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.AttrAttrGroupRelMapper;
import com.obeast.product.api.entity.AttrAttrGroupRelEntity;
import com.obeast.product.biz.service.AttrAttrGroupRelService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 属性&属性分组关联
 */
@Service("attrAttrGroupRelService")
@RequiredArgsConstructor
public class AttrAttrGroupRelServiceImpl extends ServiceImpl<AttrAttrGroupRelMapper, AttrAttrGroupRelEntity> implements AttrAttrGroupRelService {


    private final AttrService attrService;

    @Override
    public List<AttrAttrGroupDTO> listAttrByAttrGroupId(Long attrGroupId) {
        return this.listAttrIdByAttrGroupId(attrGroupId).stream().map(item -> {
            AttrEntity attrEntity = attrService.getById(item.getAttrId());
            AttrAttrGroupDTO attrAttrGroupDTO = new AttrAttrGroupDTO();
            BeanUtils.copyProperties(item, attrAttrGroupDTO);
            attrAttrGroupDTO.setAttrName(attrEntity.getAttrName());
            attrAttrGroupDTO.setValueSelect(attrEntity.getValueSelect());
            return attrAttrGroupDTO;
        }).toList();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateCategoryBrandRel(AttrAttrGroupVo attrAttrGroupVo) {
        LambdaQueryWrapper<AttrAttrGroupRelEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AttrAttrGroupRelEntity::getAttrGroupId, attrAttrGroupVo.getAttrGroupId());
        this.remove(queryWrapper);
        return this.saveBatch(attrAttrGroupVo.getAttrAttrGroupRels());
    }



    @Override
    public List<AttrAttrGroupRelEntity> listAttrIdByAttrGroupId(Long attrGroupId) {
        LambdaQueryWrapper<AttrAttrGroupRelEntity> queryWrapper = Wrappers.lambdaQuery();
        if (attrGroupId != null){
            queryWrapper.eq(AttrAttrGroupRelEntity::getAttrGroupId, attrGroupId);
            return this.list(queryWrapper);
        }else {
            return new ArrayList<>();
        }
    }
}
