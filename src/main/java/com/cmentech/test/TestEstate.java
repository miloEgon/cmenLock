package com.cmentech.test;

import com.cmentech.utils.DeanUtil;
import com.cmentech.utils.HttpUtil;
import com.cmentech.utils.JSONUtil;
import com.cmentech.utils.RouterUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestEstate
 * @Description TODO
 * @Author Cheham_Dean
 * @Date 2019/5/29 22:51
 * @Version 1.0.0
 **/
public class TestEstate {

    private static Map<String, Object> params = new HashMap<String, Object>();
    private static String baseUrl = "http://localhost:8081";
    private static String url = "";
    private static String result = "";

    /**
     * @Author Cheham_Dean
     * @Description 分页查询房产信息
     * @Date 22:50 2019/5/29
     * @Param []
     * @Return void
     **/
    public static void findEstates() {
        params.clear();
        params.put("pageNum",1);
        params.put("pageSize",5);

        url = baseUrl+"/house/findEstates";
    }

    /**
     * @Author Cheham_Dean
     * @Description 根据房产ID查询房产信息
     * @Date 22:56 2019/5/29
     * @Param []
     * @Return void
     **/
    public static void findEstateById() {
        params.clear();
        params.put("estate_id","99868b87757aaa1c643776da20f50e07");

        url = baseUrl+"/house/findEstateById";
    }

    /**
     * @Author Cheham_Dean
     * @Description 新增房产
     * @Date 22:59 2019/5/29
     * @Param []
     * @Return void
     **/
    public static void insertEstate() {
        params.clear();
        params.put("name","西溪欢乐谷一期");
        params.put("address","五常街道联创路251号");

        url = baseUrl+"/house/insertEstate";
    }

    /**
     * @Author Cheham_Dean
     * @Description 新增楼层
     * @Date 22:59 2019/5/29
     * @Param []
     * @Return void
     **/
    public static void insertFloor() {
        params.clear();
        params.put("estate_id","99868b87757aaa1c643776da20f50e07");
        params.put("name","05楼");

        url = baseUrl+"/floor/insertFloor";
    }

    /**
     * @Author Cheham_Dean
     * @Description 新增房间
     * @Date 23:00 2019/5/29
     * @Param []
     * @Return void
     **/
    public static void insertRoom() {
        params.clear();
        params.put("floor_id","09849f1b00adedae57e018ea56c1c1eb");

        url = baseUrl+"/room/countRooms";
    }

    /**
     * 获取楼层的房间列表
     */
    public static void findRooms() {
        params.clear();
        params.put("floor_id","034344209a08060b8b64455cc4eb9d36");

        url = baseUrl+"/house/findRooms";
    }

    /**
     * 绑定网关
     */
    public static void bindGateway() {
        params.clear();
        params.put("gatewaySN", DeanUtil.gatewaySN);//网关序列号
        params.put("estateId", DeanUtil.houseId);//房源ID
        url = baseUrl+"/gateway/bindGateway";
    }

    public static void findGateways() {
        params.clear();
        url = baseUrl+"/gateway/findGateways";
    }



    public static void main(String[] args){

//		  findEstates();
//        findEstateById();
//		  insertEstate();
//		  insertFloor();
//		  insertRoom();
//        findRooms();
//        bindGateway();
        findGateways();

        try {
            result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


}
