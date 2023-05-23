package com.obeast.product.biz;

import com.obeast.product.biz.service.AttrAttrGroupRelService;
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
    AttrAttrGroupRelService attrAttrGroupRelService;

    @Test
    void test1() {
        System.err.println(attrAttrGroupRelService.listAttrByAttrGroupId(2L));
        System.err.println(attrAttrGroupRelService.listAttrIdByAttrGroupId(2L));
    }
}
