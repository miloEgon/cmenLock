package com.cmentech.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestJson {

    public <T> T getJson2Bean(Class<T> clazz, String info) {
        return JSON.parseObject(info, clazz, Feature.UseBigDecimal);
    }


}
