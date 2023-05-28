package com.obeast.ware.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.ware.biz.mapper.WareInfoMapper;
import com.obeast.ware.api.entity.WareInfoEntity;
import com.obeast.ware.biz.service.WareInfoService;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 仓库信息
 */
@Service("WareInfoService")
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfoEntity> implements WareInfoService {

    @Override
    public IPage<WareInfoEntity> pageWareInfos(Page<WareInfoEntity> page, String name) {
        LambdaQueryWrapper<WareInfoEntity> queryWrapper = Wrappers.lambdaQuery();
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.like(WareInfoEntity::getName, name);
        }
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveWareInfo(WareInfoEntity wareInfoEntity) {
        return this.save(wareInfoEntity);
    }

    @Override
    public Boolean removeWareInfoById(Long id) {
        return this.removeById(id);
    }

    @Override
    public List<WareInfoEntity> listWareInfos() {
        return this.list();
    }

    @Override
    public Boolean updateWareInfo(WareInfoEntity wareInfoEntity) {
        return this.updateById(wareInfoEntity);
    }
}
