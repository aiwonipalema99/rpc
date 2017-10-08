/**
 * Zentech-Inc
 * Copyright (C) 2017 All Rights Reserved.
 */

package com.chenxj.common;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author chenxj
 * @version $Id CollectionUtil.java, v 0.1 2017-09-11 20:31 chenxj Exp $$
 */
public class CollectionUtil {

    /**
     * 判断 Collection 是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * 判断 Collection 是否非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断 Map 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return MapUtils.isEmpty(map);
    }

    /**
     * 判断 Map 是否非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}

