package com.cmentech.task;

import com.cmentech.entity.PageEntity;

public class TestTask implements Runnable {

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());


    }





}
