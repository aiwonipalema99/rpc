/**
 * Zentech-Inc
 * Copyright (C) 2017 All Rights Reserved.
 */

package com.chenxj.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenxj
 * @version $Id RpcBootStrap.java, v 0.1 2017-09-19 19:44 chenxj Exp $$
 */
public class BootStrap {
    private static final Logger LOGGER = LoggerFactory.getLogger(BootStrap.class);

    public static void main(String[] args) {
        LOGGER.debug("开启服务器");
        new ClassPathXmlApplicationContext("spring-server.xml");
    }
}

