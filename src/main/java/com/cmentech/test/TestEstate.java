package com.cmentech.test;

import com.cmentech.utils.DeanUtil;
import com.cmentech.utils.HttpUtil;
import com.cmentech.utils.JSONUtil;
import com.cmentech.utils.RouterUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        params.put("estate_id","8b8b76823b7f0583861f95edb774ddb2");

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
        params.put("estate_id","8b8b76823b7f0583861f95edb774ddb2");
//        params.put("name","01楼");

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
        params.put("estate_id","8b8b76823b7f0583861f95edb774ddb2");
//        params.put("floor_id","09849f1b00adedae57e018ea56c1c1eb");

        url = baseUrl+"/floor/insertRoom";
    }

    /**
     * 获取楼层的房间列表
     */
    public static void findRooms() {
        params.clear();
        params.put("floor_id","d9350670c88139af74f83434b4115424");

        url = baseUrl+"/house/findRooms";
    }


    public static void addGateways() {
        params.clear();

        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("gateway_id","CXAA18AAA0101466");
        map1.put("gateway_name","网关A1");
        maps.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("gateway_id","CXAA18AAA0101467");
        map2.put("gateway_name","网关A2");
        maps.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("gateway_id","CXAA18AAA0101468");
//        map3.put("gateway_name","网关A3");
        maps.add(map3);

        params.put("estate_id","8b8b76823b7f0583861f95edb774ddb2");
        params.put("list",maps);
        url = baseUrl+"/gateway/addGateway";
    }




    public static void main(String[] args){

        addGateways();

//		  findEstates();
//        findEstateById();
//        findRooms();


//		  insertEstate();
//		  insertFloor();
//		  insertRoom();

        try {
            result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


}
