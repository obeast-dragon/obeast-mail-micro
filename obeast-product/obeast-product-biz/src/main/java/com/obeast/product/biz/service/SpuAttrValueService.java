package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.SpuAttrValueEntity;

import java.util.List;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: spu属性值
 */
public interface SpuAttrValueService extends IService<SpuAttrValueEntity> {

    void saveProductAttr(List<SpuAttrValueEntity> collect);

}

