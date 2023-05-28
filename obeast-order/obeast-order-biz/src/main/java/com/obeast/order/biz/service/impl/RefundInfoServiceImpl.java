package com.obeast.order.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.order.biz.mapper.RefundInfoMapper;
import com.obeast.order.api.entity.RefundInfoEntity;
import com.obeast.order.biz.service.RefundInfoService;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 退款信息
 */
@Service("RefundInfoService")
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfoEntity> implements RefundInfoService {

    @Override
    public IPage<RefundInfoEntity> pageRefundInfos(Page<RefundInfoEntity> page) {
        LambdaQueryWrapper<RefundInfoEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveRefundInfo(RefundInfoEntity refundInfoEntity) {
        return this.save(refundInfoEntity);
    }

    @Override
    public Boolean removeRefundInfoById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateRefundInfo(RefundInfoEntity refundInfoEntity) {
        return this.updateById(refundInfoEntity);
    }
}
