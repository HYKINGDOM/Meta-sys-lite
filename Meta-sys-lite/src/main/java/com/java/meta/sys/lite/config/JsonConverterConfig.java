package com.java.meta.sys.lite.config;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;


/**
 * @author HY
 */
@Slf4j
@Configuration
public class JsonConverterConfig {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Bean
    public HttpMessageConverters httpMessageConverters(JsonSerializer<Instant> jsonSerializer,
                                                       JsonDeserializer<Instant> jsonDeserializer) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        Gson gson = new GsonBuilder()
                //这里放转换自定义管理规则
                .registerTypeAdapter(Instant.class, jsonSerializer)
                .registerTypeAdapter(Instant.class, jsonDeserializer)
                .create();
        gsonHttpMessageConverter.setGson(gson);
        return new HttpMessageConverters(gsonHttpMessageConverter);
    }


    @Bean
    public JsonSerializer<Instant> jsonSerializer() {
        return (instant, type, jsonSerializationContext) -> {
            String format = DateFormatUtils.format(Date.from(instant), DATE_FORMAT);
            return new JsonPrimitive(format);
        };
    }

    @Bean
    public JsonDeserializer<Instant> jsonDeserializer() {
        return (jsonElement, type, jsonDeserializationContext) -> {
            String dateStr = jsonElement.getAsString();
            Instant instant = null;
            try {
                instant = DateUtils.parseDate(dateStr, DATE_FORMAT).toInstant();
            } catch (ParseException exception) {
                log.error("json格式转换异常", exception);
            }
            return instant;
        };
    }

}
