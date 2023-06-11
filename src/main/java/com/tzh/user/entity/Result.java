package com.tzh.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-11 15:15
 * @Description: 返回结果集
 */
@Getter
public class Result {
    private int code;
    private String message;
    private Object data;

    private Result setResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public Result success() {
        return setResult(200, "Success", null);
    }

    public Result success(Object data) {
        return setResult(200, "Success", data);
    }
    public Result success(String message,Object data) {
        return setResult(200, message, data);
    }

    public Result fail(Object data, String message) {
        return setResult(400, message, data);
    }

    public Result fail(Object data, String message, int code) {
        return setResult(code, message, data);
    }

    public Result fail(String message, int code) {
        return setResult(code, message, null);
    }
}
