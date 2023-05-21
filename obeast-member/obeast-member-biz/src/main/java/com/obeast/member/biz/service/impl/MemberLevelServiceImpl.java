package com.obeast.member.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.MemberLevelMapper;
import com.obeast.member.api.entity.MemberLevelEntity;
import com.obeast.member.biz.service.MemberLevelService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员等级
 */
@Service("MemberLevelService")
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevelEntity> implements MemberLevelService {

    @Override
    public IPage<MemberLevelEntity> pageMemberLevels(Page<MemberLevelEntity> page, String name) {
        LambdaQueryWrapper<MemberLevelEntity> queryWrapper = Wrappers.lambdaQuery();
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.eq(MemberLevelEntity::getName, name);
        }
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMemberLevel(MemberLevelEntity memberLevelEntity) {
        return this.save(memberLevelEntity);
    }

    @Override
    public Boolean removeMemberLevelById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMemberLevel(MemberLevelEntity memberLevelEntity) {
        return this.updateById(memberLevelEntity);
    }
}
