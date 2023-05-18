package com.obeast.admin.biz.mapper;

import com.obeast.admin.api.entity.SysPost;
import com.obeast.common.mybatis.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:19
 * @version 1.0
 * Description: 岗位管理表 mapper接口
 */
@Mapper
public interface SysPostMapper extends BaseDao<SysPost> {

	/**
	 * 通过用户ID，查询岗位信息
	 * @param userId 用户id
	 * @return 岗位信息
	 */
	List<SysPost> listPostsByUserId(Long userId);

}
