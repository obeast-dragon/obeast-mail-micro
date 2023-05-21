package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.MemberLevelEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员等级
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @param name name
    * @return MemberLevelEntity
    */
    IPage<MemberLevelEntity> pageMemberLevels (Page<MemberLevelEntity> page, String name);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param memberLevelEntity MemberLevelEntity
     * @return java.lang.Boolean
     */
    Boolean saveMemberLevel(MemberLevelEntity memberLevelEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMemberLevelById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param memberLevelEntity MemberLevelEntity
     * @return java.lang.Boolean
     */
    Boolean updateMemberLevel(MemberLevelEntity memberLevelEntity);

}

