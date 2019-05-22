package com.workstudy.ssm.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseData {

    private final int code;//http代码（或者别的附加的代号）
    private final String message;//解释代码
    private final String description;//如果出错说明错误原因
    private final Map<String, Object> data = new HashMap<>();//存放的数据

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseData putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    private ResponseData(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public static ResponseData ok() {
        return new ResponseData(200, "Ok", "");
    }

    public static ResponseData ok(String description) {
        return new ResponseData(200, "Ok", description);
    }

    public static ResponseData notFound() {
        return new ResponseData(404, "Not Found", "");
    }

    public static ResponseData notFound(String description) {
        return new ResponseData(404, "Not Found", description);
    }

    public static ResponseData badRequest() {
        return new ResponseData(400, "Bad Request", "");
    }

    public static ResponseData badRequest(String description) {
        return new ResponseData(400, "Bad Request", description);
    }

    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden", "");
    }

    public static ResponseData forbidden(String description) {
        return new ResponseData(403, "Forbidden", description);
    }

    public static ResponseData unauthorized() {
        return new ResponseData(401, "Unauthorized", "");
    }

    public static ResponseData unauthorized(String description) {
        return new ResponseData(401, "Unauthorized", description);
    }

    public static ResponseData serverInternalError() {
        return new ResponseData(500, "Server Internal Error", "");
    }

    public static ResponseData serverInternalError(String description) {
        return new ResponseData(500, "Server Internal Error", description);
    }

    public static ResponseData customerError() {
        return new ResponseData(-200, "Customer Error", "");
    }

    public static ResponseData customerError(String description) {
        return new ResponseData(-200, "customer Error", description);
    }

    public Map toMap() {
        this.putDataValue("code", this.code);
        this.putDataValue("message", this.message);
        this.putDataValue("description", this.description);
        return this.getData();
    }
}