package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsMemberLevelMapper;
import com.obeast.member.api.entity.UmsMemberLevelEntity;
import com.obeast.member.biz.service.UmsMemberLevelService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员等级
 */
@Service("UmsMemberLevelService")
public class UmsMemberLevelServiceImpl extends ServiceImpl<UmsMemberLevelMapper, UmsMemberLevelEntity> implements UmsMemberLevelService {

    @Override
    public IPage<UmsMemberLevelEntity> pageUmsMemberLevels(Page<UmsMemberLevelEntity> page) {
        LambdaQueryWrapper<UmsMemberLevelEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsMemberLevel(UmsMemberLevelEntity umsMemberLevelEntity) {
        return this.save(umsMemberLevelEntity);
    }

    @Override
    public Boolean removeUmsMemberLevelById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsMemberLevel(UmsMemberLevelEntity umsMemberLevelEntity) {
        return this.updateById(umsMemberLevelEntity);
    }
}
