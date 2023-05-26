package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.SkuFullReductionEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品满减信息
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SkuFullReductionEntity
    */
    IPage<SkuFullReductionEntity> pageSkuFullReductions (Page<SkuFullReductionEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param skuFullReductionEntity SkuFullReductionEntity
     * @return java.lang.Boolean
     */
    Boolean saveSkuFullReduction(SkuFullReductionEntity skuFullReductionEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSkuFullReductionById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param skuFullReductionEntity SkuFullReductionEntity
     * @return java.lang.Boolean
     */
    Boolean updateSkuFullReduction(SkuFullReductionEntity skuFullReductionEntity);

}
