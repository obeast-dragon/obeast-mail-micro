package com.obeast.product.api.vo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wxl
 * Date 2023/5/26 10:46
 * @version 1.0
 * Description:
 */
@Data
public class Skus {

    private List<Attr> attr;
    private String skuName;
    private BigDecimal price;
    private String skuTitle;
    private String skuSubtitle;
    private List<Images> images;
    private List<String> descar;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;
}