package com.obeast.member.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.member.api.entity.MemberCollectSubjectEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收藏的专题活动
 */
@Mapper
public interface MemberCollectSubjectMapper extends BaseDao<MemberCollectSubjectEntity> {

}
