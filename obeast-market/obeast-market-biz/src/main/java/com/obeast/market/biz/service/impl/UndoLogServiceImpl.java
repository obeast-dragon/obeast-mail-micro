package com.obeast.market.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.market.biz.mapper.UndoLogMapper;
import com.obeast.market.api.entity.UndoLogEntity;
import com.obeast.market.biz.service.UndoLogService;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
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
