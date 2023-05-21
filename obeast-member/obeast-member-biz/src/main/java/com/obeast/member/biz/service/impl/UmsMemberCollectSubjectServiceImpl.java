package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsMemberCollectSubjectMapper;
import com.obeast.member.api.entity.UmsMemberCollectSubjectEntity;
import com.obeast.member.biz.service.UmsMemberCollectSubjectService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收藏的专题活动
 */
@Service("UmsMemberCollectSubjectService")
public class UmsMemberCollectSubjectServiceImpl extends ServiceImpl<UmsMemberCollectSubjectMapper, UmsMemberCollectSubjectEntity> implements UmsMemberCollectSubjectService {

    @Override
    public IPage<UmsMemberCollectSubjectEntity> pageUmsMemberCollectSubjects(Page<UmsMemberCollectSubjectEntity> page) {
        LambdaQueryWrapper<UmsMemberCollectSubjectEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsMemberCollectSubject(UmsMemberCollectSubjectEntity umsMemberCollectSubjectEntity) {
        return this.save(umsMemberCollectSubjectEntity);
    }

    @Override
    public Boolean removeUmsMemberCollectSubjectById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsMemberCollectSubject(UmsMemberCollectSubjectEntity umsMemberCollectSubjectEntity) {
        return this.updateById(umsMemberCollectSubjectEntity);
    }
}
