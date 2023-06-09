package com.obeast.member.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.member.biz.mapper.UndoLogMapper;
import com.obeast.member.api.entity.UndoLogEntity;
import com.obeast.member.biz.service.UndoLogService;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 
 */
@Service("UndoLogService")
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper, UndoLogEntity> implements UndoLogService {

    @Override
    public IPage<UndoLogEntity> pageUndoLogs(Page<UndoLogEntity> page) {
        LambdaQueryWrapper<UndoLogEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveUndoLog(UndoLogEntity undoLogEntity) {
        return this.save(undoLogEntity);
    }

    @Override
    public Boolean removeUndoLogById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateUndoLog(UndoLogEntity undoLogEntity) {
        return this.updateById(undoLogEntity);
    }
}
