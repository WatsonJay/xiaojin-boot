package org.xiaojin.common.exception;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName XiaojinBootException.java
 * @Description TODO
 * @createTime 2024年05月09日 10:10:00
 */
public class XiaojinBootException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public XiaojinBootException(String message) {
        super(message);
    }

    public XiaojinBootException(Throwable cause) {
        super(cause);
    }

    public XiaojinBootException(String message, Throwable cause) {
        super(message, cause);
    }
}
