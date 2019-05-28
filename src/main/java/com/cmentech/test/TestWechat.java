package com.cmentech.test;

import com.cmentech.utils.CommonUtil;
import com.cmentech.utils.DeanUtil;
import com.cmentech.utils.HttpUtil;
import com.cmentech.utils.JSONUtil;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestWechat {

    private static String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    private static String url = "";

    private static String result = null;

    private static Logger logger = LoggerFactory.getLogger(TestWechat.class);

    public static void getOpenId() {
        url = WX_URL.replace("APPID", DeanUtil.appId).replace("SECRET", DeanUtil.appSecret).replace("JSCODE", DeanUtil.code);
        try {
            result = HttpUtil.sendRequest(null, url, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public static Map<Object, Object> getOpenId(String code) {
        String status = "0";
        String msg = "ok";
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            if (StringUtils.isBlank(code)) {
                status = "-1";//失败状态
                msg = "code为空";
            } else {
                String requestUrl = WX_URL.replace("APPID", DeanUtil.appId).replace("SECRET", DeanUtil.appSecret).replace("JSCODE", code);
                logger.info(requestUrl);
                // 发起GET请求获取凭证
                JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
                if (jsonObject != null) {
                    try {
                        map.put("openid", jsonObject.getString("openid"));
                        map.put("session_key", jsonObject.getString("session_key"));
                    } catch (JSONException e) {
                        // 获取token失败
                        status = "-1";
                        msg = "获取token失败";
                        logger.error(msg);
                    }
                } else {
                    //code无效
                    status = "-1";
                    msg = "code无效";
                    logger.error(msg);
                }
            }
            map.put("status", status);
            map.put("msg", msg);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return map;
    }

    public static void main(String[] args) {
//        Map<Object, Object> map = getOpenId(DeanUtil.code);
//        System.out.println(map.get("openid")+"--"+map.get("session_key"));
//        logger.info(map.get("status")+"--"+map.get("msg"));
    }




}
