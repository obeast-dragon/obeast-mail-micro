package com.obeast.admin.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.admin.api.entity.SysRoleMenu;
import com.obeast.admin.biz.mapper.SysRoleMenuMapper;
import com.obeast.admin.biz.service.SysRoleMenuService;
import com.obeast.common.core.constant.CacheConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author wxl
 * Date 2023/4/10 0:21
 * @version 1.0
 * Description: 角色菜单表 服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    private final CacheManager cacheManager;

    @Override
    public List<Long> getMenuIdsByRoleId(Long roleId) {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SysRoleMenu::getRoleId, roleId);
        return this.list(queryWrapper).stream().map(SysRoleMenu::getMenuId).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveRoleMenus(Long roleId, List<Long> menuIds) {
        this.remove(Wrappers.<SysRoleMenu>query().lambda().eq(SysRoleMenu::getRoleId, roleId));
        if (menuIds.isEmpty()) {
            return Boolean.TRUE;
        }
        List<SysRoleMenu> roleMenuList = menuIds.stream().map(
                menuId -> {
                    SysRoleMenu roleMenu = new SysRoleMenu();
                    roleMenu.setRoleId(roleId);
                    roleMenu.setMenuId(menuId);
                    return roleMenu;
                }).toList();

        // 清空userinfo
        Objects.requireNonNull(cacheManager.getCache(CacheConstants.USER_DETAILS)).clear();
        // 清空全部的菜单缓存 fix #I4BM58
        Objects.requireNonNull(cacheManager.getCache(CacheConstants.MENU_DETAILS)).clear();
        return this.saveBatch(roleMenuList);
    }

}
