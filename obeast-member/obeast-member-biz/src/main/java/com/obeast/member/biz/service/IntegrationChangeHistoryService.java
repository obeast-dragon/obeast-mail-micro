package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.IntegrationChangeHistoryEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 积分变化历史记录
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return IntegrationChangeHistoryEntity
    */
    IPage<IntegrationChangeHistoryEntity> pageIntegrationChangeHistorys (Page<IntegrationChangeHistoryEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param integrationChangeHistoryEntity IntegrationChangeHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean saveIntegrationChangeHistory(IntegrationChangeHistoryEntity integrationChangeHistoryEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeIntegrationChangeHistoryById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param integrationChangeHistoryEntity IntegrationChangeHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean updateIntegrationChangeHistory(IntegrationChangeHistoryEntity integrationChangeHistoryEntity);

}

