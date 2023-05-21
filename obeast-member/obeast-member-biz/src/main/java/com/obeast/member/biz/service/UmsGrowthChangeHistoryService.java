package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UmsGrowthChangeHistoryEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 成长值变化历史记录
 */
public interface UmsGrowthChangeHistoryService extends IService<UmsGrowthChangeHistoryEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UmsGrowthChangeHistoryEntity
    */
    IPage<UmsGrowthChangeHistoryEntity> pageUmsGrowthChangeHistorys (Page<UmsGrowthChangeHistoryEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param umsGrowthChangeHistoryEntity UmsGrowthChangeHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean saveUmsGrowthChangeHistory(UmsGrowthChangeHistoryEntity umsGrowthChangeHistoryEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUmsGrowthChangeHistoryById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param umsGrowthChangeHistoryEntity UmsGrowthChangeHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean updateUmsGrowthChangeHistory(UmsGrowthChangeHistoryEntity umsGrowthChangeHistoryEntity);

}

