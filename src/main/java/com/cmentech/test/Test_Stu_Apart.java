package com.cmentech.test;

import com.cmentech.constant.HttpConstant;
import com.cmentech.utils.HttpUtil;
import com.cmentech.utils.RouterUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        params.put("pageSize", 100);
        params.put("pageNum", 1);
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

    public static void getIDCard() {
        url = "http://127.0.0.1:8849/custom";
    }


    public static void main(String[] args) {
        getIDCard();
        try {
//            result = HttpUtil.sendRequest(JSONUtil.toJSONString(params), url, true); //Post
            result = HttpUtil.sendRequest(null, url, false); //Get
            String[] split = result.split("\n");
            String name = split[0];
            String cardNum = split[1];

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1024; i++) {
                sb = sb.append("0");
            }
            String fingerprint1 = split[2].substring(0, 1024);
            String fingerprint2 = split[2].substring(1024, split[2].length());

            System.out.println(fingerprint1.getBytes().length);


            System.out.println("姓名："+name);
            System.out.println("号码："+cardNum);
            System.out.println("指纹1："+fingerprint1+", \n"+fingerprint1.length());
            System.out.println("指纹2："+fingerprint2+", \n"+fingerprint2.length());
            /*test(fingerprint1);
            test(fingerprint2);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String radomCode(int length) {
        StringBuffer sb = new StringBuffer();

        Random ra = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(ra.nextInt(10));
        }

        return sb.toString();
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static void test(String fingerprint) {
        String filename = System.currentTimeMillis() + radomCode(6);

        FileOutputStream fos = null;

        File file = new File("C:\\Native\\home\\upfile\\");
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File("C:\\Native\\home\\upfile\\" + filename + ".mb");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            int length = fingerprint.length() / 2;
            char[] hexChars = fingerprint.toCharArray();
            byte[] d = new byte[length << 1];
            for (int i = 0; i < length; i++) {
                int pos = i * 2;
                d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
                System.out.println(d[i]);
            }

            fos.write(d);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        /*int length = 512;
//        int i = length << 1;
//        System.out.println(i);*/
//        String string = "4301121201104F00000000000000000000000025019AFFFFFFFFFFFFFFFFFFAC0E18FCC52215FC573320FCD73801FC7F3F1CFCAD3EC6FC934714FCA94908FC8851C8FCCB4F67FEF450A9FCC566B0FC9E6708FC6A731CFCE37E51FE6D82D4FCE48FA0FC949B0BFCE9A24DFECAA7ACFCB5B361FE9CB9C2FC47BD27FCAACF60FE6CD31EFC8DE103FC34F4E5FC6F1125FD932008FD252438FDA92C53FF403233FDEB4486FDAF4F30FFD5502DFF8357DBFDA659D6FD000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000B9000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E";
//
//
////        int a = 1, b = 2;
////        System.out.println(String.format("%d, %d", a++, a));
////        System.out.println(String.format("%d, %d", ++a, a));
////        if ( ++b == 3 | a++ == 2 ) {
////            System.out.println(String.format("%d, %d", a, b));
////        }
//
//        char[] chars = string.toCharArray();
//        byte[] bytes = new byte[1024];
//        for (int i = 0; i < chars.length; i++) {
//            bytes[i] = charToByte(chars[i]);
//        }
//
////        Integer.toHexString(200); //十进制转十六进制
//
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(bytes[i]);
//        }
//
//        System.out.println();
//
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(Integer.toHexString(bytes[i]).toUpperCase());
//        }
//
////
////        byte b1 = charToByte(c);
////        System.out.println(b1);
//
//
//    }


}
