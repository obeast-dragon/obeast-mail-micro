package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.product.api.entity.SpuInfoDescEntity;


/**
 * @author wxl
 * Date 2023-05-26 17:28:37
 * @version 1.0
 * Description: spu信息介绍
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SpuInfoDescEntity
    */
    IPage<SpuInfoDescEntity> pageSpuInfoDescs (Page<SpuInfoDescEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param spuInfoDescEntity SpuInfoDescEntity
     * @return java.lang.Boolean
     */
    Boolean saveSpuInfoDesc(SpuInfoDescEntity spuInfoDescEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSpuInfoDescById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param spuInfoDescEntity SpuInfoDescEntity
     * @return java.lang.Boolean
     */
    Boolean updateSpuInfoDesc(SpuInfoDescEntity spuInfoDescEntity);

}

