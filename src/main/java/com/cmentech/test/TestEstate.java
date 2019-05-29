package com.cmentech.test;

import com.cmentech.utils.HttpUtil;
import com.cmentech.utils.JSONUtil;

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
        params.put("pageSize",10);

        url = "http://localhost:8081/house/findEstates";
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

        url = "http://localhost:8081/house/findEstateById";
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

        url = "http://localhost:8081/house/insertEstate";
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

        url = "http://localhost:8081/floor/insertFloor";
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

        url = "http://localhost:8081/room/countRooms";
    }

    public static void main(String[] args){

//		findEstates();
      findEstateById();
//		insertEstate();
//		insertFloor();
//		insertRoom();

        try {
            result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


}
