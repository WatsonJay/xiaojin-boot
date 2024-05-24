package org.xiaojin.common.constant;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName ResultCodeConstant.java
 * @Description TODO
 * @createTime 2024年05月24日 15:22:00
 */
public interface ResultCodeConstant {

    /** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
    Integer RQ_INTERNAL_SERVER_ERROR_500 = 500;
    /** {@code 404 Not Found} (HTTP/1.0 - RFC 1945) */
    Integer RQ_INTERNAL_NOT_FOUND_404 = 404;
    /** {@code 200 OK} (HTTP/1.0 - RFC 1945) */
    Integer RQ_OK_200 = 200;
    /**访问权限认证未通过 510*/
    Integer RQ_XIAOJIN_NO_AUTHZ = 510;
}
