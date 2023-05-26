package com.obeast.product.api.feign;

import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.SysConstants;
import com.obeast.product.api.to.SkuReductionTo;
import com.obeast.product.api.to.SpuBoundTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wxl
 * Date 2023/5/26 21:15
 * @version 1.0
 * Description: 商品spu积分设置feign
 */
@FeignClient(contextId = "remoteSpuBoundsSevice", value = SysConstants.Server.MARKET_SERVICE)
public interface RemoteSpuBoundsService {

    @PostMapping("/spuBounds/add")
    CommonResult<?> saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);



    @PostMapping("/skuFullReduction/addInfo")
    CommonResult<?> saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
