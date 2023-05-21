package com.obeast.admin.biz;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.admin.api.dto.UserDTO;
import com.obeast.admin.api.vo.UserVO;
import com.obeast.admin.biz.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wxl
 * Date 2023/5/1 10:49
 * @version 1.0
 * Description:
 */
@SpringBootTest
public class AdminApplicationTest {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysOauthClientDetailsService sysOauthClientDetailsService;


    @Autowired
    private SysDictItemService sysDictItemService;


    @Autowired
    private SysDictService sysDictService;

    @Test
    void test1() {
        System.err.println(sysDictService.page(new Page<>()).getRecords());
    }
}
