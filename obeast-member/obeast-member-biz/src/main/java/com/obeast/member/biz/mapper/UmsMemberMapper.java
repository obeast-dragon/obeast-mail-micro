package com.obeast.member.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.member.api.entity.UmsMemberEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员
 */
@Mapper
public interface UmsMemberMapper extends BaseDao<UmsMemberEntity> {

}
