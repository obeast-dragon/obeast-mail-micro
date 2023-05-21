package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.MemberCollectSpuMapper;
import com.obeast.member.api.entity.MemberCollectSpuEntity;
import com.obeast.member.biz.service.MemberCollectSpuService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收藏的商品
 */
@Service("MemberCollectSpuService")
public class MemberCollectSpuServiceImpl extends ServiceImpl<MemberCollectSpuMapper, MemberCollectSpuEntity> implements MemberCollectSpuService {

    @Override
    public IPage<MemberCollectSpuEntity> pageMemberCollectSpus(Page<MemberCollectSpuEntity> page) {
        LambdaQueryWrapper<MemberCollectSpuEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMemberCollectSpu(MemberCollectSpuEntity memberCollectSpuEntity) {
        return this.save(memberCollectSpuEntity);
    }

    @Override
    public Boolean removeMemberCollectSpuById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMemberCollectSpu(MemberCollectSpuEntity memberCollectSpuEntity) {
        return this.updateById(memberCollectSpuEntity);
    }
}
