package com.obeast.product.api.constant;

/**
 * @author wxl
 * Date 2023/5/29 12:42
 * @version 1.0
 * Description: 商品常量
 */
public class ProductConstant {
    public enum  AttrEnum{
        ATTR_TYPE_BASE(1,"基本属性"),ATTR_TYPE_SALE(0,"销售属性");
        private final int code;
        private final String msg;

        AttrEnum(int code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
