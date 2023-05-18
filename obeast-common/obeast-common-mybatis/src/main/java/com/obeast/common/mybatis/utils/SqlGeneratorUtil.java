package com.obeast.common.mybatis.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wxl
 * Date 2022/12/4 19:53
 * @version 1.0
 * Description: 根据JAVA实体生成SQL建表语句工具
 */
@Slf4j
public class SqlGeneratorUtil {

    public static Map<String, String> property2SqlColumnMap = new HashMap<>();

    public static void main(String[] args) {
//        Class<BendanSysRole> aClass = BendanSysRole.class;
//        generateSql(aClass, "bendan_sys_role", "id", "E:\\bendan_sys_role.sql");
        generateSql(null, "bendan_sys_user", "id", "E:\\bendan_sys_user.sql");
    }

    static {
        property2SqlColumnMap.put("integer", "INT");
        property2SqlColumnMap.put("short", "tinyint");
        property2SqlColumnMap.put("long", "bigint");
        property2SqlColumnMap.put("bigdecimal", "decimal(19,2)");
        property2SqlColumnMap.put("double", "double precision not null");
        property2SqlColumnMap.put("float", "float");
        property2SqlColumnMap.put("boolean", "bit");
        property2SqlColumnMap.put("timestamp", "datetime");
        property2SqlColumnMap.put("date", "datetime");
        property2SqlColumnMap.put("string", "VARCHAR(256)");
    }


    public static String generateSql(Class<?> clz, String tableName, String primaryKey, String filePath) {
        Field[] fields = clz.getDeclaredFields();
        StringBuffer column = new StringBuffer();
        for (Field f : fields) {
            if (f.getName().equals(primaryKey)) {
                continue;
            }
            //column.append(" \n `"+f.getName()+"`").append(varchar);
            column.append(getColumnSql(f));
        }
        String sqlPrimaryKey = StringUtils.camelToUnderline(primaryKey).toUpperCase();
        StringBuffer sql = new StringBuffer();
        sql.append("\n DROP TABLE IF EXISTS `" + tableName + "`; ")
                .append(" \n CREATE TABLE `" + tableName + "`  (")
                .append(" \n `" + sqlPrimaryKey + "` bigint(20) NOT NULL AUTO_INCREMENT,")
                .append(" \n " + column)
                .append(" \n PRIMARY KEY (`" + sqlPrimaryKey + "`)")
                .append(" \n ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;");
        String sqlText = sql.toString();
        StringToSql(sqlText, filePath);
        return sqlText;
    }

    private static String getColumnSql(Field field) {
        String tpl = "\n `%s` %s DEFAULT NULL,";
        String typeName = field.getType().getSimpleName().toLowerCase();
        String sqlType = property2SqlColumnMap.get(typeName);
        if (sqlType == null || sqlType.isEmpty()) {
            log.info(field.getName() + ":" + field.getType().getName() + " 需要单独创建表");
            return "";
        }
        String column = StringUtils.camelToUnderline(field.getName()).toUpperCase();
        String sql = String.format(tpl, column, sqlType.toUpperCase());
        return sql;
    }

    private static void StringToSql(String str, String path) {
        byte[] sourceByte = str.getBytes();
        if (null != sourceByte) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);
                outStream.write(sourceByte);
                outStream.flush();
                outStream.close();
                System.out.println("生成成功");
            } catch (Exception e) {
                log.debug("保存SQL文件异常：", e);
            }
        }
    }
}

