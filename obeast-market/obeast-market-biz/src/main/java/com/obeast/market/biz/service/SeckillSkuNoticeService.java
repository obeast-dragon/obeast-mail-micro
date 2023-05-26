package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.SeckillSkuNoticeEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀商品通知订阅
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SeckillSkuNoticeEntity
    */
    IPage<SeckillSkuNoticeEntity> pageSeckillSkuNotices (Page<SeckillSkuNoticeEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param seckillSkuNoticeEntity SeckillSkuNoticeEntity
     * @return java.lang.Boolean
     */
    Boolean saveSeckillSkuNotice(SeckillSkuNoticeEntity seckillSkuNoticeEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSeckillSkuNoticeById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param seckillSkuNoticeEntity SeckillSkuNoticeEntity
     * @return java.lang.Boolean
     */
    Boolean updateSeckillSkuNotice(SeckillSkuNoticeEntity seckillSkuNoticeEntity);

}

