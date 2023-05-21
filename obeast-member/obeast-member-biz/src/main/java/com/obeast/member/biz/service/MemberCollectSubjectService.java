package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.MemberCollectSubjectEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收藏的专题活动
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return MemberCollectSubjectEntity
    */
    IPage<MemberCollectSubjectEntity> pageMemberCollectSubjects (Page<MemberCollectSubjectEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param memberCollectSubjectEntity MemberCollectSubjectEntity
     * @return java.lang.Boolean
     */
    Boolean saveMemberCollectSubject(MemberCollectSubjectEntity memberCollectSubjectEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMemberCollectSubjectById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param memberCollectSubjectEntity MemberCollectSubjectEntity
     * @return java.lang.Boolean
     */
    Boolean updateMemberCollectSubject(MemberCollectSubjectEntity memberCollectSubjectEntity);

}

