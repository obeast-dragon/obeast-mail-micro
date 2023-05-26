package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.SpuInfoEntity;
import com.obeast.product.api.vo.SpuSaveVo;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: spu信息
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    /**
     * Description:
     * 1、保存spu基本信息pms_spu_info
     * 2、保存spu的描述图片pms_spu_info_desc
     * 3、保存spu的图片集pms_spu_images
     * 4、保存spu的规格参数pms_product_attr_value
     * 5、保存spu的积分信息beastmail_sms---》sms_spu_bounds
     * 6、保存当前spu对应的所有sku信息
     *     6.1、sku的基本信息；pms_sku_info
     *     6.2、sku的图片信息；pms_sku_images
     *     6.3、sku的销售属性信息；pms_sku_sale_attr_value
     *      6.4、sku的基本信息；beastmail_sms----》sms_sku_ladder、sms_sku_full_reduction
     *
     * @author wxl
     * Date: 2023/5/27 0:35
     * @param spuSaveVo spuSaveVo
     */
    CommonResult<?> saveSpuInfo(SpuSaveVo spuSaveVo);
}

