package com.cmentech.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Calendar cale = null;

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Description:获取下个月的今天
     * @return
     * @author Cheham_Dean
     * @date 2019年3月11日上午11:48:30
     */
    public static String getNextMonth() {
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH,1);
        return format.format(cale.getTime());
    }

    public static String getToday() {
        return format.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getToday());
        System.out.println(getNextMonth());
    }

}
