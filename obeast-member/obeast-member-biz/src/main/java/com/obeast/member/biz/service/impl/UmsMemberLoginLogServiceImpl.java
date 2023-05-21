package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UmsMemberLoginLogMapper;
import com.obeast.member.api.entity.UmsMemberLoginLogEntity;
import com.obeast.member.biz.service.UmsMemberLoginLogService;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员登录记录
 */
@Service("UmsMemberLoginLogService")
public class UmsMemberLoginLogServiceImpl extends ServiceImpl<UmsMemberLoginLogMapper, UmsMemberLoginLogEntity> implements UmsMemberLoginLogService {

    @Override
    public IPage<UmsMemberLoginLogEntity> pageUmsMemberLoginLogs(Page<UmsMemberLoginLogEntity> page) {
        LambdaQueryWrapper<UmsMemberLoginLogEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUmsMemberLoginLog(UmsMemberLoginLogEntity umsMemberLoginLogEntity) {
        return this.save(umsMemberLoginLogEntity);
    }

    @Override
    public Boolean removeUmsMemberLoginLogById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUmsMemberLoginLog(UmsMemberLoginLogEntity umsMemberLoginLogEntity) {
        return this.updateById(umsMemberLoginLogEntity);
    }
}
