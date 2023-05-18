package com.obeast.admin.biz.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.admin.api.dto.UserDTO;
import com.obeast.admin.api.entity.SysUser;
import com.obeast.admin.api.vo.UserVO;
import com.obeast.common.mybatis.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:20
 * @version 1.0
 * Description: 用户表 Mapper 接口
 */
@Mapper
public interface SysUserMapper extends BaseDao<SysUser> {

	/**
	 * 通过用户名查询用户信息（含有角色信息）
	 * @param username 用户名
	 * @return userVo
	 */
	UserVO getUserVoByUsername(String username);

	/**
	 * 分页查询用户信息（含角色）
	 * @param page 分页
	 * @param userDTO 查询参数
	 * @return list
	 */
	IPage<UserVO> getUserVosPage(Page<?> page, @Param("query") UserDTO userDTO);

	/**
	 * 通过ID查询用户信息
	 * @param id 用户ID
	 * @return userVo
	 */
	UserVO getUserVoById(Long id);

	/**
	 * 查询用户列表
	 * @param userDTO 查询条件
	 * @return List<UserVO>
	 */
	List<UserVO> selectVoList(@Param("query") UserDTO userDTO);

}
