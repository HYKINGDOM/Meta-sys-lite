package com.java.meta.sys.lite.common.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author HY
 */
public class GsonUtils {


    public static Map toMap(String json) {
        TypeToken<Map<Object, Object>> typeToken = new TypeToken<Map<Object, Object>>() {
        };
        return GsonSingleton.getGsonUtils().gson.fromJson(json, typeToken.getType());
    }

    public static <K, V> Map<K, V> toMap(String json, Type type) {
        TypeToken<Map<K, V>> typeToken = new TypeToken<Map<K, V>>() {
        };
        return GsonSingleton.getGsonUtils().gson.fromJson(json, typeToken.getType());
    }

    public static <T> List<T> toList(String json) {
        TypeToken<List<T>> typeToken = new TypeToken<List<T>>() {
        };
        return GsonSingleton.getGsonUtils().gson.fromJson(json, typeToken.getType());
    }

    public static <T> List<T> toList(String json, Type type) {
        return GsonSingleton.getGsonUtils().gson.fromJson(json, type);
    }

    public static String toJsonString(Object object) {
        return GsonSingleton.getGsonUtils().gson.toJson(object);
    }


    public String toJsonString(Object object, String dateFormatPattern) {
        return GsonSingleton.getGsonUtils().gsonBuilder.setDateFormat(dateFormatPattern).create().toJson(object);
    }


    public static <T> T toObject(String json, Class<T> valueType) {
        return GsonSingleton.getGsonUtils().gson.fromJson(json, valueType);
    }


    public static <K, V> Map<K, V> objectToMap(Object fromValue) {
        TypeToken<Map<Object, Object>> typeToken = new TypeToken<Map<Object, Object>>() {
        };
        String json = GsonSingleton.getGsonUtils().gson.toJson(fromValue);
        return GsonSingleton.getGsonUtils().gson.fromJson(json, typeToken.getType());
    }


    public static <T> T mapToObject(Map fromMap, Class<T> toValueType) {
        String json = GsonSingleton.getGsonUtils().gson.toJson(fromMap);
        return toObject(json, toValueType);
    }


    public static class GsonSingleton {

        private volatile static GsonSingleton gsonSingleton;

        public Gson gson;

        public GsonBuilder gsonBuilder;

        public static GsonSingleton getGsonUtils() {

            if (gsonSingleton == null) {
                synchronized (GsonUtils.class) {
                    if (gsonSingleton == null) {
                        gsonSingleton = new GsonSingleton();
                    }
                    return gsonSingleton;
                }
            }
            return gsonSingleton;
        }

        public GsonSingleton() {
            gsonBuilder = new GsonBuilder()
                    // 解决Gson序列化时出现整型变为浮点型的问题
                    .registerTypeAdapter(new TypeToken<Map<Object, Object>>() {
                            }.getType(),
                            (JsonDeserializer<Map<Object, Object>>) (jsonElement, type, jsonDeserializationContext) -> {
                                Map<Object, Object> map = new LinkedHashMap<>();
                                JsonObject jsonObject = jsonElement.getAsJsonObject();
                                Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                                for (Map.Entry<String, JsonElement> entry : entrySet) {
                                    Object obj = entry.getValue();
                                    if (obj instanceof JsonPrimitive) {
                                        map.put(entry.getKey(), ((JsonPrimitive) obj).getAsString());
                                    } else {
                                        map.put(entry.getKey(), obj);
                                    }
                                }
                                return map;
                            }
                    )
                    .registerTypeAdapter(new TypeToken<List<Object>>() {
                            }.getType(),
                            (JsonDeserializer<List<Object>>) (jsonElement, type, jsonDeserializationContext) -> {
                                List<Object> list = new LinkedList<>();
                                JsonArray jsonArray = jsonElement.getAsJsonArray();
                                for (int i = 0; i < jsonArray.size(); i++) {
                                    if (jsonArray.get(i).isJsonObject()) {
                                        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                                        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                                        list.addAll(entrySet);
                                    } else if (jsonArray.get(i).isJsonPrimitive()) {
                                        list.add(jsonArray.get(i));
                                    }
                                }
                                return list;
                            }
                    );
            gson = gsonBuilder.create();
        }
    }

}
