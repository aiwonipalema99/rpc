/**
 * Zentech-Inc
 * Copyright (C) 2017 All Rights Reserved.
 */

package com.chenxj.web.controller;

import com.chenxj.client.RpcProxy;
import com.chenxj.server.HelloSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxj
 * @version $Id Controller.java, v 0.1 2017-09-20 21:29 chenxj Exp $$
 */
@RestController
public class Controller {

    @Autowired
    private RpcProxy proxy;

    @RequestMapping("/user")
    public String getNmae(String name) {
        HelloSerivce helloService = proxy.create(HelloSerivce.class);
        return helloService.hello(name);
    }

}

