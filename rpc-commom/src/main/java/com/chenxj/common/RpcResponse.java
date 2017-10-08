/**
 * Zentech-Inc
 * Copyright (C) 2017 All Rights Reserved.
 */

package com.chenxj.common;

import java.io.Serializable;

/**
 * @author chenxj
 * @version $Id RpcResponse.java, v 0.1 2017-09-11 20:34 chenxj Exp $$
 */
public class RpcResponse implements Serializable {

    private static final long serialVersionUID = 9179937526911541455L;
    private String requestId;
    private Exception exception;
    private Object result;

    public boolean hasException() {
        return exception != null;
    }

    /**
     * Getter method for property <tt>requestId</tt>.
     *
     * @return property value of requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Setter method for property <tt>requestId</tt>.
     *
     * @param requestId value to be assigned to property requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Getter method for property <tt>exception</tt>.
     *
     * @return property value of exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Setter method for property <tt>exception</tt>.
     *
     * @param exception value to be assigned to property exception
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     * Getter method for property <tt>result</tt>.
     *
     * @return property value of result
     */
    public Object getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     *
     * @param result value to be assigned to property result
     */
    public void setResult(Object result) {
        this.result = result;
    }
}

