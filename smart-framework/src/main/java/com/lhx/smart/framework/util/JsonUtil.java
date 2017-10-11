package com.lhx.smart.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String toJson(T obj){
        String json;
        try {
            json=OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("pojo序列化失败",e);
            throw  new RuntimeException(e);
        }
        return json;
    }
    public static <T> T fromJson(String json,Class<T> type){
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json,type);
        } catch (IOException e) {
            LOGGER.error("json反序列化失败",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
