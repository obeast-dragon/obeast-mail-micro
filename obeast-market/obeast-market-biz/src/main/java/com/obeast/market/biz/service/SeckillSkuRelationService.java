package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.SeckillSkuRelationEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动商品关联
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SeckillSkuRelationEntity
    */
    IPage<SeckillSkuRelationEntity> pageSeckillSkuRelations (Page<SeckillSkuRelationEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param seckillSkuRelationEntity SeckillSkuRelationEntity
     * @return java.lang.Boolean
     */
    Boolean saveSeckillSkuRelation(SeckillSkuRelationEntity seckillSkuRelationEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSeckillSkuRelationById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param seckillSkuRelationEntity SeckillSkuRelationEntity
     * @return java.lang.Boolean
     */
    Boolean updateSeckillSkuRelation(SeckillSkuRelationEntity seckillSkuRelationEntity);

}

