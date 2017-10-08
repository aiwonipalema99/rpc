/**
 * Zentech-Inc
 * Copyright (C) 2017 All Rights Reserved.
 */

package com.chenxj.server;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 *
 * @author chenxj
 * @version $Id RpcService.java, v 0.1 2017-09-11 20:21 chenxj Exp $$
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RpcService {

    /**
     * 服务接口类
     */
    Class<?> value();

}

