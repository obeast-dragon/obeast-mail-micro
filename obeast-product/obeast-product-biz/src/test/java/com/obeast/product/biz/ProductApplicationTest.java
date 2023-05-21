package com.obeast.product.biz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.product.biz.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wxl
 * Date 2023/5/21 0:30
 * @version 1.0
 * Description:
 */
@SpringBootTest
public class ProductApplicationTest {

    @Autowired
    BrandService brandService;

    @Test
    void test1() {
        System.err.println(brandService.page(new Page<>()).getRecords());
    }
}
