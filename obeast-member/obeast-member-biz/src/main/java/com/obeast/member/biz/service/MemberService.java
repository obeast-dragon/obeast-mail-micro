package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.MemberEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员
 */
public interface MemberService extends IService<MemberEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return MemberEntity
    */
    IPage<MemberEntity> pageMembers (Page<MemberEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param memberEntity MemberEntity
     * @return java.lang.Boolean
     */
    Boolean saveMember(MemberEntity memberEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMemberById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param memberEntity MemberEntity
     * @return java.lang.Boolean
     */
    Boolean updateMember(MemberEntity memberEntity);

}

