package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.HomeAdvMapper;
import com.obeast.market.api.entity.HomeAdvEntity;
import com.obeast.market.biz.service.HomeAdvService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 首页轮播广告
 */
@Service("HomeAdvService")
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvMapper, HomeAdvEntity> implements HomeAdvService {

    @Override
    public IPage<HomeAdvEntity> pageHomeAdvs(Page<HomeAdvEntity> page) {
        LambdaQueryWrapper<HomeAdvEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveHomeAdv(HomeAdvEntity homeAdvEntity) {
        return this.save(homeAdvEntity);
    }

    @Override
    public Boolean removeHomeAdvById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateHomeAdv(HomeAdvEntity homeAdvEntity) {
        return this.updateById(homeAdvEntity);
    }
}
