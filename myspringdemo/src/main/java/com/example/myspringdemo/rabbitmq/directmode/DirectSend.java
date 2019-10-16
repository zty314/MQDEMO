package com.example.myspringdemo.rabbitmq.directmode;

import com.example.myspringdemo.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


public class DirectSend {

    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception  {

        Connection c = ConnectionUtil.getConnection();
        Channel channel = c.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        String s = "今天吃了吗？";
        channel.basicPublish(EXCHANGE_NAME,"delete",null,s.getBytes());
        System.out.println("message====="+s);

        channel.close();
        c.close();
    }
}
