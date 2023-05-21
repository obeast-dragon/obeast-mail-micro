package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsMemberCollectSpuMapper;
import com.obeast.member.api.entity.UmsMemberCollectSpuEntity;
import com.obeast.member.biz.service.UmsMemberCollectSpuService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收藏的商品
 */
@Service("UmsMemberCollectSpuService")
public class UmsMemberCollectSpuServiceImpl extends ServiceImpl<UmsMemberCollectSpuMapper, UmsMemberCollectSpuEntity> implements UmsMemberCollectSpuService {

    @Override
    public IPage<UmsMemberCollectSpuEntity> pageUmsMemberCollectSpus(Page<UmsMemberCollectSpuEntity> page) {
        LambdaQueryWrapper<UmsMemberCollectSpuEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsMemberCollectSpu(UmsMemberCollectSpuEntity umsMemberCollectSpuEntity) {
        return this.save(umsMemberCollectSpuEntity);
    }

    @Override
    public Boolean removeUmsMemberCollectSpuById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsMemberCollectSpu(UmsMemberCollectSpuEntity umsMemberCollectSpuEntity) {
        return this.updateById(umsMemberCollectSpuEntity);
    }
}
