package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UmsMemberCollectSubjectEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收藏的专题活动
 */
public interface UmsMemberCollectSubjectService extends IService<UmsMemberCollectSubjectEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UmsMemberCollectSubjectEntity
    */
    IPage<UmsMemberCollectSubjectEntity> pageUmsMemberCollectSubjects (Page<UmsMemberCollectSubjectEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param umsMemberCollectSubjectEntity UmsMemberCollectSubjectEntity
     * @return java.lang.Boolean
     */
    Boolean saveUmsMemberCollectSubject(UmsMemberCollectSubjectEntity umsMemberCollectSubjectEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUmsMemberCollectSubjectById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param umsMemberCollectSubjectEntity UmsMemberCollectSubjectEntity
     * @return java.lang.Boolean
     */
    Boolean updateUmsMemberCollectSubject(UmsMemberCollectSubjectEntity umsMemberCollectSubjectEntity);

}

