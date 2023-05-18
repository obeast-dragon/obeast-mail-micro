package com.obeast.common.mybatis.xss;


import lombok.SneakyThrows;
import org.springframework.util.StringUtils;

/**
 * @author wxl
 * Date 2023/4/10 0:00
 * @version 1.0
 * Description: SQL过滤
 */
public class SQLFilter {

    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    @SneakyThrows
    public static String sqlInject(String str){
        if(!StringUtils.hasText(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.contains(keyword)){
                throw new Exception("包含非法字符");
            }
        }

        return str;
    }
}
