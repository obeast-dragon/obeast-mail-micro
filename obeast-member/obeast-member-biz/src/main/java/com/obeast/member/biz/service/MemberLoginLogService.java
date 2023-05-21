package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.MemberLoginLogEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员登录记录
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return MemberLoginLogEntity
    */
    IPage<MemberLoginLogEntity> pageMemberLoginLogs (Page<MemberLoginLogEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param memberLoginLogEntity MemberLoginLogEntity
     * @return java.lang.Boolean
     */
    Boolean saveMemberLoginLog(MemberLoginLogEntity memberLoginLogEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMemberLoginLogById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param memberLoginLogEntity MemberLoginLogEntity
     * @return java.lang.Boolean
     */
    Boolean updateMemberLoginLog(MemberLoginLogEntity memberLoginLogEntity);

}

