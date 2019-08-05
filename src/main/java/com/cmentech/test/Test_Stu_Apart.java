package com.cmentech.test;

import com.cmentech.constant.HttpConstant;
import com.cmentech.entity.ResponseEntity;
import com.cmentech.utils.HttpUtil;
import com.cmentech.utils.JSONUtil;
import com.cmentech.utils.RouterUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test_Stu_Apart {


    private static Map<String, Object> params = new HashMap<String, Object>();

    private static String baseUrl = HttpConstant.getBaseUrl();

    private static String url = "";

    private static String result = null;

    private static String perCode = "0303130103";
//    private static String perCode = "20021546";


    /**
     * 5.1	获取用户有权开启的门锁
     */
    public static void getLocks() {
        params.clear();
        params.put("perCode", perCode);//学号
        params.put("pageSize",100);
        params.put("pageNum",1);
        url = baseUrl + RouterUtil.user_lock_getLocks;
    }

    /**
     * 5.2	远程开锁
     */
    public static void unlock() {
        params.clear();
        params.put("perCode", perCode);//学号
        params.put("lockId", "7be7c0773b5a4e1a9e79210f9c55cdb5"); //锁ID
        url = baseUrl + RouterUtil.user_lock_unlock;
    }

    /**
     * 5.3	获取开锁结果
     */
    public static void queryResult() {
        url = baseUrl + RouterUtil.user_lock_query_result + "/8ee21930225549e3af5f81847dbffd5b";
    }





    public static void main(String[] args) {
//        getLocks();
//        unlock();
        queryResult();
        try {
//            result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true); //Post
            result = HttpUtil.sendRequest(null, url, false); //Get
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
//		System.out.println(JSONUtil.parse2Bean(result, ResponseEntity.class));
    }











}
