package com.lhx.smart.framework.bean;

import com.lhx.smart.framework.util.CastUtil;

import java.util.Map;

public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
