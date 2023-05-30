package com.obeast.ware.biz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.ware.biz.service.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wxl
 * Date 2023/5/30 13:10
 * @version 1.0
 * Description:
 */
@SpringBootTest
public class WareApplicationTest {

    @Autowired
    PurchaseService purchaseService;

    @Test
    void test1() {
        System.err.println(purchaseService.pageUnclaimedPurchases(new Page<>()).getRecords());
    }
}
