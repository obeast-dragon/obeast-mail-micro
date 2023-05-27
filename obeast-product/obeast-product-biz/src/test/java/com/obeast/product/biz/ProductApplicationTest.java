package com.obeast.product.biz;

import com.obeast.product.api.entity.SpuInfoEntity;
import com.obeast.product.biz.service.*;
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
    SpuInfoService spuInfoService;

    @Test
    void test1() {
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        spuInfoEntity.setBrandId(1L);
        spuInfoService.save(spuInfoEntity);
    }
}
