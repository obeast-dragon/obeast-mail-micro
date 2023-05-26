package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.SeckillSessionEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动场次
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SeckillSessionEntity
    */
    IPage<SeckillSessionEntity> pageSeckillSessions (Page<SeckillSessionEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param seckillSessionEntity SeckillSessionEntity
     * @return java.lang.Boolean
     */
    Boolean saveSeckillSession(SeckillSessionEntity seckillSessionEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSeckillSessionById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param seckillSessionEntity SeckillSessionEntity
     * @return java.lang.Boolean
     */
    Boolean updateSeckillSession(SeckillSessionEntity seckillSessionEntity);

}

