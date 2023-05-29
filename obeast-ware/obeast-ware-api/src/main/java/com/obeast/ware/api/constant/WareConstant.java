package com.obeast.ware.api.constant;

/**
 * @author wxl
 * Date 2023/5/29 12:41
 * @version 1.0
 * Description: 库存常量
 */
public class WareConstant {
    public enum  PurchaseStatusEnum{
        CREATED(0,"新建"),
        ASSIGNED(1,"已分配"),
        RECEIVED(2,"已领取"),
        FINISH(3,"已完成"),
        HAS_ERROR(4,"有异常");
        private final int code;
        private final String msg;

        PurchaseStatusEnum(int code,String msg){
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
    public enum  PurchaseDetailStatusEnum{
//        '状态[0新建，1已分配，2正在采购，3已完成，4采购失败]'
        CREATED(0,"新建"),
        ASSIGNED(1,"已分配"),
        BUYING(2,"正在采购"),
        FINISH(3,"已完成"),
        PURCHASE_FAIL(4,"采购失败");
        private final int code;
        private final String msg;

        PurchaseDetailStatusEnum(int code,String msg){
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
