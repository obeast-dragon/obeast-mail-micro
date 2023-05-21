package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.GrowthChangeHistoryEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 成长值变化历史记录
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return GrowthChangeHistoryEntity
    */
    IPage<GrowthChangeHistoryEntity> pageGrowthChangeHistorys (Page<GrowthChangeHistoryEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param growthChangeHistoryEntity GrowthChangeHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean saveGrowthChangeHistory(GrowthChangeHistoryEntity growthChangeHistoryEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeGrowthChangeHistoryById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param growthChangeHistoryEntity GrowthChangeHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean updateGrowthChangeHistory(GrowthChangeHistoryEntity growthChangeHistoryEntity);

}

