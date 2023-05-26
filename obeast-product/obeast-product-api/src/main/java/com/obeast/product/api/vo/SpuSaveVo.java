package com.obeast.product.api.vo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wxl
 * Date 2023/5/26 10:44
 * @version 1.0
 * Description:
 */
@Data
public class SpuSaveVo {

    private String spuName;
    private String spuDescription;
    private Long categoryId;
    private Long brandId;
    private BigDecimal weight;
    private int publishStatus;
    private List<String> descImgs;
    private List<String> goodsImgs;
    private Bounds bounds;
    private List<BaseAttrs> baseAttrs;
    private List<Skus> skus;

}