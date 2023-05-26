package com.obeast.product.api.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wxl
 * Date 2023/5/26 10:47
 * @version 1.0
 * Description:
 */
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}