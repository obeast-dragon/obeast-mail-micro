package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.HomeAdvEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 首页轮播广告
 */
public interface HomeAdvService extends IService<HomeAdvEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return HomeAdvEntity
    */
    IPage<HomeAdvEntity> pageHomeAdvs (Page<HomeAdvEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param homeAdvEntity HomeAdvEntity
     * @return java.lang.Boolean
     */
    Boolean saveHomeAdv(HomeAdvEntity homeAdvEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeHomeAdvById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param homeAdvEntity HomeAdvEntity
     * @return java.lang.Boolean
     */
    Boolean updateHomeAdv(HomeAdvEntity homeAdvEntity);

}

