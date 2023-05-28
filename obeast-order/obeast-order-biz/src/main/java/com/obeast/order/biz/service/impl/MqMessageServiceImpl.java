package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.MqMessageMapper;
import com.obeast.order.api.entity.MqMessageEntity;
import com.obeast.order.biz.service.MqMessageService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 
 */
@Service("MqMessageService")
public class MqMessageServiceImpl extends ServiceImpl<MqMessageMapper, MqMessageEntity> implements MqMessageService {

    @Override
    public IPage<MqMessageEntity> pageMqMessages(Page<MqMessageEntity> page) {
        LambdaQueryWrapper<MqMessageEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveMqMessage(MqMessageEntity mqMessageEntity) {
        return this.save(mqMessageEntity);
    }

    @Override
    public Boolean removeMqMessageById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateMqMessage(MqMessageEntity mqMessageEntity) {
        return this.updateById(mqMessageEntity);
    }
}
