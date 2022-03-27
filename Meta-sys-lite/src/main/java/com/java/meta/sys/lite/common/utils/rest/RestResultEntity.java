package com.java.meta.sys.lite.common.utils.rest;


import lombok.Getter;
import lombok.Setter;

/**
 * 数据返回消息实体
 * @author HY
 */
@Getter
@Setter
public class RestResultEntity{

    private String code;

    private String msg;

    private Object data;

    private String timestamp;
}
