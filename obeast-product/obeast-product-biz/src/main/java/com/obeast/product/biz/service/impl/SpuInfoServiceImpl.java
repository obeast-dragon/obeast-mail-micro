package com.obeast.product.biz.service.impl;

import com.obeast.common.core.base.CommonResult;
import com.obeast.product.api.entity.*;
import com.obeast.product.api.feign.RemoteSpuBoundsService;
import com.obeast.product.api.to.SkuReductionTo;
import com.obeast.product.api.to.SpuBoundTo;
import com.obeast.product.api.vo.*;
import com.obeast.product.biz.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.SpuInfoMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: spu信息
 */
@Service("spuInfoService")
@RequiredArgsConstructor
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfoEntity> implements SpuInfoService {

    private final SpuInfoDescService spuInfoDescService;


    private final SpuImagesService imagesService;


    private final AttrService attrService;


    private final SpuAttrValueService spuAttrValueService;


    private final SkuInfoService skuInfoService;


    private final SkuImagesService skuImagesService;


    private final SkuSaleAttrValueService skuSaleAttrValueService;


    private final RemoteSpuBoundsService remoteSpuBoundsService;



    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveSpuInfo(SpuSaveVo spuVo) {
        /*
            1、保存spu基本信息pms_spu_info
            2、保存spu的描述图片pms_spu_info_desc
            3、保存spu的图片集pms_spu_images
            4、保存spu的规格参数pms_product_attr_value
            5、保存spu的积分信息beastmail_sms---》sms_spu_bounds
            6、保存当前spu对应的所有sku信息
                6.1、sku的基本信息；pms_sku_info
                6.2、sku的图片信息；pms_sku_images
                6.3、sku的销售属性信息；pms_sku_sale_attr_value
                6.4、sku的基本信息；beastmail_sms----》sms_sku_ladder、sms_sku_full_reduction
         */

        // 1
        SpuInfoEntity spuInfo = new SpuInfoEntity();
        BeanUtils.copyProperties(spuVo, spuInfo);
        spuInfo.setId(1L);

        // 2
        List<String> descImgs = spuVo.getDescImgs();
        SpuInfoDescEntity spuInfoDesc = new SpuInfoDescEntity();
        spuInfoDesc.setSpuId(spuInfo.getId());
        spuInfoDesc.setDecript(String.join(",", descImgs));
        spuInfoDescService.saveSpuInfoDesc(spuInfoDesc);

        // 3
        List<String> goodsImgs = spuVo.getGoodsImgs();
        imagesService.saveImages(spuInfo.getId(), goodsImgs);


        //4、
        List<BaseAttrs> baseAttrs = spuVo.getBaseAttrs();
        List<SpuAttrValueEntity> SpuAttrValues = baseAttrs.stream().map(attr -> {
            SpuAttrValueEntity spuAttrValue = new SpuAttrValueEntity();
            BeanUtils.copyProperties(attr, spuAttrValue);
            spuAttrValue.setQuickShow(attr.getShowDesc());
            spuAttrValue.setSpuId(spuInfo.getId());
            return spuAttrValue;
        }).collect(Collectors.toList());
        spuAttrValueService.saveProductAttr(SpuAttrValues);


        //5、保存spu的积分信息beastmail_sms---》sms_spu_bounds//TODO
        Bounds bounds = spuVo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds, spuBoundTo);
        spuBoundTo.setSpuId(spuInfo.getId());
        CommonResult<?> saveSpuBounds = remoteSpuBoundsService.saveSpuBounds(spuBoundTo);
        if (!saveSpuBounds.getSuccess()) {
            log.error("远程调用保存spu积分信息失败");
        }


        //6、
        List<Skus> skus = spuVo.getSkus();
        if (skus != null && skus.size() > 0) {
            skus.forEach(item -> {
                String defaultImg = "";
                for (Images image : item.getImages()) {
                    if (image.getDefaultImg() == 1) {
                        defaultImg = image.getUrl();
                    }
                }
                //6.1、sku的基本信息：pms_sku_info
                SkuInfoEntity skuInfoEntity = new SkuInfoEntity();
                BeanUtils.copyProperties(item, skuInfoEntity);
                skuInfoEntity.setBrandId(spuInfo.getBrandId());
                skuInfoEntity.setCategoryId(spuInfo.getCategoryId());
                skuInfoEntity.setSkuDefaultImg(defaultImg);
                skuInfoEntity.setSaleCount(0L);
                skuInfoEntity.setSpuId(spuInfo.getId());
                skuInfoService.saveSkuInfo(skuInfoEntity);
                //====================================
                Long skuId = skuInfoEntity.getSkuId();

                //6.2、sku的图片信息；pms_sku_image
                List<SkuImagesEntity> skuImages = item.getImages().stream().map(img -> {
                    SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                    skuImagesEntity.setSkuId(skuId);
                    skuImagesEntity.setImgUrl(img.getUrl());
                    skuImagesEntity.setDefaultImg(img.getDefaultImg());
                    return skuImagesEntity;
                }).filter(entity -> StringUtils.hasText(entity.getImgUrl())).collect(Collectors.toList());
                skuImagesService.saveBatch(skuImages);
                //====================================

                //6.3、sku的销售规格信息；pms_sku_sale_attr_value
                List<Attr> attrs = item.getAttr();
                List<SkuSaleAttrValueEntity> skuSaleAttrValues = attrs.stream().map(a -> {
                    SkuSaleAttrValueEntity skuSaleAttrValueEntity = new SkuSaleAttrValueEntity();
                    BeanUtils.copyProperties(a, skuSaleAttrValueEntity);
                    skuSaleAttrValueEntity.setSkuId(skuId);
                    return skuSaleAttrValueEntity;
                }).collect(Collectors.toList());
                skuSaleAttrValueService.saveBatch(skuSaleAttrValues);

                //6.4、sku的基本信息；beastmail_sms----》sms_sku_ladder、sms_sku_full_reduction TODO
                SkuReductionTo skuReductionTo = new SkuReductionTo();
                BeanUtils.copyProperties(item, skuReductionTo);
                skuReductionTo.setSkuId(skuId);

                if (skuReductionTo.getFullCount() > 0 || skuReductionTo.getFullPrice().compareTo(new BigDecimal("0")) == 1) {
                    CommonResult<?> saveSkuReduction = remoteSpuBoundsService.saveSkuReduction(skuReductionTo);
                    if (!saveSkuReduction.getSuccess()) {
                        log.error("远程调用保存sku优惠信息失败");
                    }
                }
            });
        }
        return null;
    }

}
