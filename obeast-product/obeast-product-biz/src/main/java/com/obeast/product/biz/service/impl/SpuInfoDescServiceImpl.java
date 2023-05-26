package com.obeast.product.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.product.biz.mapper.SpuInfoDescMapper;
import com.obeast.product.api.entity.SpuInfoDescEntity;
import com.obeast.product.biz.service.SpuInfoDescService;



/**
 * @author wxl
 * Date 2023-05-26 17:28:37
 * @version 1.0
 * Description: spu信息介绍
 */
@Service("SpuInfoDescService")
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescMapper, SpuInfoDescEntity> implements SpuInfoDescService {

    @Override
    public IPage<SpuInfoDescEntity> pageSpuInfoDescs(Page<SpuInfoDescEntity> page) {
        LambdaQueryWrapper<SpuInfoDescEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveSpuInfoDesc(SpuInfoDescEntity spuInfoDescEntity) {
//        return this.save(spuInfoDescEntity);
        return Boolean.TRUE;
    }

    @Override
    public Boolean removeSpuInfoDescById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateSpuInfoDesc(SpuInfoDescEntity spuInfoDescEntity) {
        return this.updateById(spuInfoDescEntity);
    }
}
