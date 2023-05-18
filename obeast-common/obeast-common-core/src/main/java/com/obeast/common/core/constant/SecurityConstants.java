package com.obeast.common.core.constant;

/**
 * @author wxl
 * Date 2022/10/20 11:31
 * @version 1.0
 * Description: 客户端常量
 */
public interface SecurityConstants {

    /**
     * {bcrypt} 加密的特征码
     */
    String BCRYPT = "{bcrypt}";

    /**
     * {noop} 加密的特征码
     */
    String NOOP = "{noop}";


    /**
     * 默认登录URL
     */
    String OAUTH_TOKEN_URL = "/oauth2/token";

    /**
     * 授权码模式confirm
     */
    String CUSTOM_CONSENT_PAGE_URI = "/token/confirm_access";


    /**
     * access_token
     * */
    String ACCESS_TOKEN = "access_token";

    /**
     * refresh_token
     * */
    String REFRESH_TOKEN = "refresh_token";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * redis 存储 token 名字
     * */
    String TOKEN = "token";

    /**
     *  AUTHORIZATION header
     * */
    String AUTHORIZATION = "Authorization";

    /**
     * userinfo
     * */
    String USERINFO = "userinfo";

    /**
     * 客户端ID
     */
    String CLIENT_ID = "clientId";


    /**
     * 内部
     */
    String FROM_IN = "Y";

    /**
     * 标志
     */
    String FROM = "from";

    /**
     * 请求header
     */
    String HEADER_FROM_IN = FROM + "=" + FROM_IN;

    /**
     * 验证码有效期,默认 60秒
     */
    long CODE_TIME = 60;

    /**
     * 短信登录 参数名称
     */
    String SMS_PARAMETER_NAME = "phone";
    /**
     * 验证码长度
     */
    String CODE_SIZE = "6";

    /**
     * 手机号登录
     */
    String APP = "app";

    /**
     * 协议字段
     */
    String DETAILS_LICENSE = "license";


    /**
     * 项目的license
     */
    String PROJECT_LICENSE = "https://pig4cloud.com";

    /**
     * 客户端模式
     */
    String CLIENT_CREDENTIALS = "client_credentials";

    /**
     * 用户信息
     */
    String DETAILS_USER = "user_info";



    enum Type {
        MIN_APP("min-app"),
        WEB_BROWSER("web-browser"),
        ;
        private final String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    enum RequestTokenParam {
        CLIENT_ID("client-id"),
        CLIENT_SECRET("client-secret"),
        GRANT_TYPE("grant-type"),
        USERNAME("username"),
        PASSWORD("password"),
        ;
        private final String name;
        RequestTokenParam(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    enum GrantType {
        AUTHORIZATION_CODE("authorization_code"),
        /** @deprecated */
        @Deprecated
        IMPLICIT("implicit"),
        REFRESH_TOKEN("refresh_token"),
        CLIENT_CREDENTIALS("client_credentials"),
        PASSWORD("password"),
        WT_BEARER("urn:ietf:params:oauth:grant-type:jwt-bearer")
        ;
        private final String name;


        GrantType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    enum Scope{
        ALL("all"),
        READ("message.read"),
        WRITE("message.write")
        ;
        private final String name;

        Scope(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


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
        return String.format("%s::%s::%s", TOKEN, type, value);
    }
}
