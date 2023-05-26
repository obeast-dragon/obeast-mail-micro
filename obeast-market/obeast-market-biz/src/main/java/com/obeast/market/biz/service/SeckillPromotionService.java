package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.SeckillPromotionEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SeckillPromotionEntity
    */
    IPage<SeckillPromotionEntity> pageSeckillPromotions (Page<SeckillPromotionEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param seckillPromotionEntity SeckillPromotionEntity
     * @return java.lang.Boolean
     */
    Boolean saveSeckillPromotion(SeckillPromotionEntity seckillPromotionEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSeckillPromotionById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param seckillPromotionEntity SeckillPromotionEntity
     * @return java.lang.Boolean
     */
    Boolean updateSeckillPromotion(SeckillPromotionEntity seckillPromotionEntity);

}

