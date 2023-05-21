package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UmsIntegrationChangeHistoryEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 积分变化历史记录
 */
public interface UmsIntegrationChangeHistoryService extends IService<UmsIntegrationChangeHistoryEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UmsIntegrationChangeHistoryEntity
    */
    IPage<UmsIntegrationChangeHistoryEntity> pageUmsIntegrationChangeHistorys (Page<UmsIntegrationChangeHistoryEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param umsIntegrationChangeHistoryEntity UmsIntegrationChangeHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean saveUmsIntegrationChangeHistory(UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistoryEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUmsIntegrationChangeHistoryById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param umsIntegrationChangeHistoryEntity UmsIntegrationChangeHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean updateUmsIntegrationChangeHistory(UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistoryEntity);

}

