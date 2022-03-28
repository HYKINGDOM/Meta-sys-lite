package com.java.meta.sys.lite.common.utils.rest;

import cn.hutool.core.util.ObjectUtil;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

/**
 * 构建返回消息
 *
 * @author HY
 */
@NoArgsConstructor
public class SyncResult extends RestResultEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 初始化SyncResult
     *
     * @param returnType 状态类型
     * @param msg        返回内容
     */
    public SyncResult(ReturnType returnType, String msg) {
        this.setCode(returnType.getCode());
        this.setMsg(msg);
    }

    /**
     * 初始化SyncResult
     *
     * @param returnType 状态类型
     * @param msg        返回消息
     * @param data       数据对象
     */
    public SyncResult(ReturnType returnType, String msg, Object data) {
        this.setCode(returnType.getCode());
        this.setMsg(msg);
        this.setData(Optional.ofNullable(data).orElse(null));
    }

    /**
     * 初始化SyncResult
     *
     * @param code 状态码
     * @param msg  返回消息
     * @param data 数据对象
     */
    public SyncResult(String code, String msg, Object data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(Optional.ofNullable(data).orElse(null));
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static SyncResult success() {
        return SyncResult.success(ReturnType.SUCCESS.getMsg());
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static SyncResult success(Object data) {
        return SyncResult.success(ReturnType.SUCCESS.getMsg(), data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static SyncResult success(String msg) {
        return SyncResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static SyncResult success(String msg, Object data) {
        return new SyncResult(ReturnType.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static SyncResult warn(String msg) {
        return SyncResult.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static SyncResult warn(String msg, Object data) {
        return new SyncResult(ReturnType.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static SyncResult error(String msg) {
        return SyncResult.error(msg, null);
    }


    /**
     * 返回自定义错误码和错误消息
     *
     * @param code
     * @param msg
     * @return
     */
    public static SyncResult error(String code, String msg) {
        return new SyncResult(code, msg, null);
    }


    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return
     */
    public static SyncResult error(String msg, Object data) {
        return new SyncResult(ReturnType.ERROR, msg, data);
    }


}
