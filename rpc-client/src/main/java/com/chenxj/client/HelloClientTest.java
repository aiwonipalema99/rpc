/**
 * Zentech-Inc
 * Copyright (C) 2017 All Rights Reserved.
 */

package com.chenxj.client;

import com.chenxj.server.HelloSerivce;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenxj
 * @version $Id HelloClient.java, v 0.1 2017-09-19 19:45 chenxj Exp $$
 */
public class HelloClientTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-client.xml");
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);

        int loopCount = 100;

        long start = System.currentTimeMillis();

        HelloSerivce helloService = rpcProxy.create(HelloSerivce.class);
        for (int i = 0; i < loopCount; i++) {
            String result = helloService.hello("chenxj");
            System.out.println(result);
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("loop: " + loopCount);
        System.out.println("time: " + time + "ms");
        System.out.println("tps: " + (double) loopCount / ((double) time / 1000));

        System.exit(0);
    }
}

