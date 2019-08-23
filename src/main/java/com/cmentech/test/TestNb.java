package com.cmentech.test;

import com.cmentech.constant.HttpConstant;
import com.cmentech.utils.DeanUtil;
import com.cmentech.utils.HttpUtil;
import com.cmentech.utils.JSONUtil;
import com.cmentech.utils.RouterUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestNb {

    private static Map<String, Object> params = new HashMap<String, Object>();

    private static String baseUrl = HttpConstant.getTestNburl();

    private static String url = "";

    private static String result = null;

    public static void gatewayPermitJoin() {
        params.clear();
        params.put("gatewaySN", "865462042529574");//网关序列号
        params.put("roomId", "7f7f4b5c8a02428485738829c560166e");//房间ID
        params.put("taskType", 0);//NB设备
        url = baseUrl + RouterUtil.gateway_permitJoin;
    }

    public static void inquireLocks() {
        params.clear();
        params.put("houseId", "8b8b76823b7f0583861f95edb774ddb2");//房源ID
        url = baseUrl + RouterUtil.inquire_locks;
    }

    public static void inquireLock() {
        params.clear();
//        params.put("lockId", "38e09913-2abb-437f-b732-1ca55df92271");//锁ID
        params.put("lockId", "0f8a443475e44a12993167d7bd34bf9e");//锁ID
        url = baseUrl + RouterUtil.inquire_lock;
    }

    public static void deviceLockOperationUnlock() {
        params.clear();
        params.put("lockId", "22fed0b7-275b-4ca2-86e9-042d3c9f67d6");//锁ID
        params.put("taskType", 0);//NB设备
        params.put("password", "qwiTMrvMt6GK+dkfs/EcXg==");
        url = baseUrl + RouterUtil.device_lock_operation_unlock;
    }

    public static void main(String[] args) {
//        gatewayPermitJoin();
//        inquireLocks();
//        inquireLock();
        deviceLockOperationUnlock();
        try {
            result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
