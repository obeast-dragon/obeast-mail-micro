package com.obeast.product.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.SpuAttrValueMapper;
import com.obeast.product.api.entity.SpuAttrValueEntity;
import com.obeast.product.biz.service.SpuAttrValueService;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: spu属性值
 */
@Service("spuAttrValueService")
public class SpuAttrValueServiceImpl extends ServiceImpl<SpuAttrValueMapper, SpuAttrValueEntity> implements SpuAttrValueService {


    @Override
    public List<SpuAttrValueEntity> listBySpuId(Long spuId) {
        LambdaQueryWrapper<SpuAttrValueEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SpuAttrValueEntity::getSpuId, spuId);
        return this.list(queryWrapper);
    }

    @Override
    public void saveProductAttr(List<SpuAttrValueEntity> spuAttrValues) {
        this.saveBatch(spuAttrValues);
    }
}
