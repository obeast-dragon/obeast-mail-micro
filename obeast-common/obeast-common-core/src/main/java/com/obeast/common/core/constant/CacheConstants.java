package com.obeast.common.core.constant;

/**
 * @author wxl
 * Date 2022/12/9 13:32
 * @version 1.0
 * Description: L2 缓存常量
 */
public interface CacheConstants {


    /**
     * oauth 缓存前缀
     */
    String PROJECT_OAUTH_ACCESS = "token::access_token";


    /**
     * 菜单信息缓存
     */
    String MENU_DETAILS = "MENU_LIST";


    /**
     * 商品分类信息缓存
     */
    String CATEGORY_DETAILS = "CATEGORY_DETAILS";


    /**
     * 菜单信息缓存
     */
    String USERNAME_LIST = "USERNAME_LIST";


    /**
     * 参数缓存
     */
    String PARAMS_DETAILS = "params_details";

    /**
     * 字典信息缓存
     */
    String DICT_DETAILS = "dict_details";

    /**
     * 用户信息缓存
     */
    String USER_DETAILS = "user_details";

    /**
     * oauth 客户端信息
     */
    String CLIENT_DETAILS_KEY = "client:details";

    /**
     * 二级缓存名字
     * */
    String USER_INFO = "USER_INFO";

    /**
     * token 名
     * */
    String TOKEN = "token";


    /**
     * 邮箱验证码
     * */
    String MAIL_VERIFICATION_CODE = "MAIL_VERIFICATION_CODE";

    /**
     * 验证码前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY:";

    /**
     * Description: 创建redis存储的key
     *
     * @param type  token type
     * @param value token value
     * @return java.lang.String
     * @author wxl
     * Date: 2022/10/31 17:02
     */
    static String createRedisKey(String type, String value) {
        return String.format("%s::%s::%s", CacheConstants.TOKEN, type, value);
    }
}
