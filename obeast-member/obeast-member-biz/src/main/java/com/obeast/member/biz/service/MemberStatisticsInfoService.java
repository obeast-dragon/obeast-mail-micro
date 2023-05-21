package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.MemberStatisticsInfoEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员统计信息
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return MemberStatisticsInfoEntity
    */
    IPage<MemberStatisticsInfoEntity> pageMemberStatisticsInfos (Page<MemberStatisticsInfoEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param memberStatisticsInfoEntity MemberStatisticsInfoEntity
     * @return java.lang.Boolean
     */
    Boolean saveMemberStatisticsInfo(MemberStatisticsInfoEntity memberStatisticsInfoEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMemberStatisticsInfoById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param memberStatisticsInfoEntity MemberStatisticsInfoEntity
     * @return java.lang.Boolean
     */
    Boolean updateMemberStatisticsInfo(MemberStatisticsInfoEntity memberStatisticsInfoEntity);

}

