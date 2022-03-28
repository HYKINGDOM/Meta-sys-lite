package com.java.meta.sys.lite.common.utils.rest;


import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * 数据返回消息实体
 *
 * @author HY
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResultEntity implements Serializable {

    @Expose(serialize = false, deserialize = false)
    private String module = "meta-sys-lite";

    private String code;

    private String msg;

    private Object data;

    private Long time = Instant.now().toEpochMilli();
}
