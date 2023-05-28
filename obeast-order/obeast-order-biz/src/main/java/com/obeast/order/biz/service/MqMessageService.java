package com.obeast.order.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.api.entity.MqMessageEntity;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 
 */
public interface MqMessageService extends IService<MqMessageEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return MqMessageEntity
    */
    IPage<MqMessageEntity> pageMqMessages (Page<MqMessageEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param mqMessageEntity MqMessageEntity
     * @return java.lang.Boolean
     */
    Boolean saveMqMessage(MqMessageEntity mqMessageEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMqMessageById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param mqMessageEntity MqMessageEntity
     * @return java.lang.Boolean
     */
    Boolean updateMqMessage(MqMessageEntity mqMessageEntity);

}

