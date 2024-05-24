package org.xiaojin.common.exception;

import org.xiaojin.common.constant.CommonConstant;
import org.xiaojin.common.constant.ResultCodeConstant;

/**
 * @author JayWatson
 * @version 1.0.0
 * @ClassName XiaojinBootException.java
 * @Description TODO
 * @createTime 2024年05月09日 10:10:00
 */
public class XiaojinBootException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int errCode = ResultCodeConstant.RQ_INTERNAL_SERVER_ERROR_500;

    public XiaojinBootException(String message) {
        super(message);
    }

    public XiaojinBootException(String message, int errCode){
        super(message);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public XiaojinBootException(Throwable cause) {
        super(cause);
    }

    public XiaojinBootException(String message, Throwable cause) {
        super(message, cause);
    }
}
