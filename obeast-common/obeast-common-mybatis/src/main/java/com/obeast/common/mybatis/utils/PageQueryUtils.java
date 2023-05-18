package com.obeast.common.mybatis.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.common.mybatis.domain.PageObjects;
import com.obeast.common.mybatis.domain.PageParams;
import com.obeast.common.mybatis.xss.SQLFilter;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/3 21:41
 * @version 1.0
 * Description: 分页查询工具类
 */
public class PageQueryUtils<T> {


    public <T> PageObjects<T> getPageObjects(IPage<T> page, Class<T> targetClass) {
        return getPageObjects(page.getRecords(), page.getTotal(), targetClass);

    }

    public  <T> PageObjects<T> getPageObjects(List<?> items, long total, Class<T> targetClass) {
        List<T> targetList = ClassConvertorUtils.sourceToTarget(items, targetClass);
        return new PageObjects<>(total, targetList);

    }


    /**
     * Description: 分页方法
     * @author wxl
     * Date: 2022/12/21 15:12
     * @param pageParams 分页参数
     * @return com.baomidou.mybatisplus.core.metadata.IPage<T>
     */
    public IPage<T> getPage(PageParams pageParams) {
        long curPage = 1;
        long limit = 10;

//        接口用
        if (pageParams.getCur() != null) {
            curPage = pageParams.getCur();
        }
        if (pageParams.getLimit() != null) {
            limit = pageParams.getLimit();
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject(pageParams.getOrderField());
        Boolean order = pageParams.getOrder();

        //没有排序字段，则不排序
        if (StringUtils.isBlank(orderField)) {
            return page;
        }

        //默认排序
        if (order) {
            page.addOrder(OrderItem.asc(orderField));
        } else {
            page.addOrder(OrderItem.desc(orderField));
        }

        return page;
    }


}
