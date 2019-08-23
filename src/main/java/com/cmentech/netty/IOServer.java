package com.cmentech.netty;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {

    public static void main(String[] args) throws IOException {
        /*ServerSocket serverSocket = new ServerSocket(8000);

        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();*/

        Jedis jedis = new Jedis("10.10.1.132",6379,100);
        jedis.auth("123456");

//        jedis.setex("milo",30, "egon");
        if (jedis.exists("milo")) {
            String milo = jedis.get("milo");
            System.out.println(milo);
        }
    }


}
