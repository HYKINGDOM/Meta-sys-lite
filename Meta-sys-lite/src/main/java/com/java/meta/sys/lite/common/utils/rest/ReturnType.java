package com.java.meta.sys.lite.common.utils.rest;

/**
 * @author HY
 */
public enum ReturnType {

    /**
     * 成功
     */
    SUCCESS("200", "操作成功!"),

    /**
     * 警告
     */
    WARN("301", "Warning"),

    /**
     * 错误
     */
    ERROR("500", "Error");


    ReturnType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;


    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
