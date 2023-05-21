package com.obeast.member.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.member.api.entity.IntegrationChangeHistoryEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 积分变化历史记录
 */
@Mapper
public interface IntegrationChangeHistoryMapper extends BaseDao<IntegrationChangeHistoryEntity> {

}
