package com.obeast.ware.api.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wxl
 * Date 2023/5/29 10:36
 * @version 1.0
 * Description:
 */
@Data
public class PurchaseMergeVo {

    @NotNull(message = "采购单Id不能为空")
    private Long purchaseId;

    private List<Long> items;
}
