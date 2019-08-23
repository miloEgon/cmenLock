package com.cmentech.test;

import com.cmentech.constant.HttpConstant;
import com.cmentech.utils.HttpUtil;
import com.cmentech.utils.JSONUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestShuidi {

    private static Map<String, Object> params = new HashMap<String, Object>();

    private static String baseUrl = HttpConstant.getBaseUrl();

    private static String url = "";

    private static String result = null;

    public static void inquireLocks() throws IOException {
        url = baseUrl + "/inquire/getAllLocks";
        result = HttpUtil.sendRequest(null, url, false);
        System.out.println(result);
    }

    public static void getLocksByPage() throws IOException {
        params.clear();
        params.put("pageNum", 4);
        params.put("pageSize", 3);
        url = baseUrl + "/inquire/getLocksByPage";
        result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true);
        System.out.println(result);
    }

    public static void main(String[] args) {
        try {
            getLocksByPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
