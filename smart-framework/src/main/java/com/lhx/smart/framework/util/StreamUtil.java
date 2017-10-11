package com.lhx.smart.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流取字符串
     *
     * @param inputStream
     * @return
     */
    public static String getString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            LOGGER.error("读取失败",e);
            throw  new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
