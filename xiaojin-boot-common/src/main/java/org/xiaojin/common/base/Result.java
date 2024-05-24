package org.xiaojin.common.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import org.xiaojin.common.constant.ResultCodeConstant;

import java.io.Serializable;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName Result.java
 * @Description TODO
 * @createTime 2024年05月21日 11:07:00
 */
@Data
@Schema(description="接口返回对象")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    @Schema(description = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @Schema(description = "返回处理消息")
    private String message = "";

    /**
     * 返回代码
     */
    @Schema(description = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    @Schema(description = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
    @Schema(description = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result<T> success(String message) {
        this.message = message;
        this.code = ResultCodeConstant.RQ_OK_200;
        this.success = true;
        return this;
    }

    public static<T> Result<T> ok() {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultCodeConstant.RQ_OK_200);
        return r;
    }

    public static<T> Result<T> ok(String msg) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultCodeConstant.RQ_OK_200);
        //Result OK(String msg)方法会造成兼容性问题 issues/I4IP3D
        r.setResult((T) msg);
        r.setMessage(msg);
        return r;
    }

    public static<T> Result<T> ok(T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultCodeConstant.RQ_OK_200);
        r.setResult(data);
        return r;
    }

    public static<T> Result<T> OK() {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultCodeConstant.RQ_OK_200);
        return r;
    }

    public static<T> Result<T> OK(T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultCodeConstant.RQ_OK_200);
        r.setResult(data);
        return r;
    }

    public static<T> Result<T> OK(String msg, T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultCodeConstant.RQ_OK_200);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static<T> Result<T> error(String msg, T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(false);
        r.setCode(ResultCodeConstant.RQ_INTERNAL_SERVER_ERROR_500);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static<T> Result<T> error(String msg) {
        return error(ResultCodeConstant.RQ_INTERNAL_SERVER_ERROR_500, msg);
    }

    public static<T> Result<T> error(int code, String msg) {
        Result<T> r = new Result<T>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public Result<T> error500(String message) {
        this.message = message;
        this.code = ResultCodeConstant.RQ_INTERNAL_SERVER_ERROR_500;
        this.success = false;
        return this;
    }

    /**
     * 无权限访问返回结果
     */
    public static<T> Result<T> noauth(String msg) {
        return error(ResultCodeConstant.RQ_XIAOJIN_NO_AUTHZ, msg);
    }

    @JsonIgnore
    private String onlTable;
}
