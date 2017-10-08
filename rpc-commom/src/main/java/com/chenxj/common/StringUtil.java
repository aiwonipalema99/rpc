/**
 * Zentech-Inc
 * Copyright (C) 2017 All Rights Reserved.
 */

package com.chenxj.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chenxj
 * @version $Id StringUtil.java, v 0.1 2017-09-11 20:30 chenxj Exp $$
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 分割固定格式的字符串
     */
    public static String[] split(String str, String separator) {
        return StringUtils.splitByWholeSeparator(str, separator);
    }
}

