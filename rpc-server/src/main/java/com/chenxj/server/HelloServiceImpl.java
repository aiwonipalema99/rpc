/**
 * Zentech-Inc
 * Copyright (C) 2017 All Rights Reserved.
 */

package com.chenxj.server;

/**
 * @author chenxj
 * @version $Id HelloServiceImpl.java, v 0.1 2017-09-19 19:19 chenxj Exp $$
 */
@RpcService(HelloSerivce.class)
public class HelloServiceImpl implements HelloSerivce {
    @Override
    public String hello(String name) {
        return "welcome " + name;
    }
}

