package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UmsMemberLoginLogEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员登录记录
 */
public interface UmsMemberLoginLogService extends IService<UmsMemberLoginLogEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UmsMemberLoginLogEntity
    */
    IPage<UmsMemberLoginLogEntity> pageUmsMemberLoginLogs (Page<UmsMemberLoginLogEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param umsMemberLoginLogEntity UmsMemberLoginLogEntity
     * @return java.lang.Boolean
     */
    Boolean saveUmsMemberLoginLog(UmsMemberLoginLogEntity umsMemberLoginLogEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUmsMemberLoginLogById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param umsMemberLoginLogEntity UmsMemberLoginLogEntity
     * @return java.lang.Boolean
     */
    Boolean updateUmsMemberLoginLog(UmsMemberLoginLogEntity umsMemberLoginLogEntity);

}

