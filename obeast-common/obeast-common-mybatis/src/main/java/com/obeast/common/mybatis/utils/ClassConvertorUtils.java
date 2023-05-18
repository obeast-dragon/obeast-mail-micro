package com.obeast.common.mybatis.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.*;

/**
 * @author wxl
 * Date 2023/4/3 21:39
 * @version 1.0
 * Description: 类转换工具
 */
@Slf4j
@UtilityClass
public class ClassConvertorUtils {


    public <T> List<T> sourceToTarget(Collection<?> sourceList, Class<T> target) {
        if (sourceList == null) return null;

        List<T> targetList = new ArrayList<>(sourceList.size());
        try {
            for (Object source : sourceList){
                T targetObject = target.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(source, targetObject);
                targetList.add(targetObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception while converting sourceList to target ara error");
        }
        return targetList;
    }



}
