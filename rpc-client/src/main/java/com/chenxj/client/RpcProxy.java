package com.chenxj.client;

import com.chenxj.common.RpcRequest;
import com.chenxj.common.RpcResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * 客户端代理
 *
 * @author chenxj
 * @version $Id ServiceDiscovery.java, v 0.1 2017-09-11 20:41 chenxj Exp $$
 */
public class RpcProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcProxy.class);

    private String ip;

    private int port;

    public RpcProxy(String ip, int port) {

        this.ip = ip;
        this.port = port;
    }


    @SuppressWarnings("unchecked")
    public <T> T create(Class<?> interfaceClass) {
        // 创建动态代理对象
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 创建 RPC 请求对象并设置请求属性
                        RpcRequest request = new RpcRequest();
                        request.setRequestId(UUID.randomUUID().toString());
                        request.setInterfaceName(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParameters(args);
                        // 创建 RPC 客户端对象并发送 RPC 请求
                        RpcClient client = new RpcClient(ip, port);
                        long time = System.currentTimeMillis();
                        RpcResponse response = client.send(request);
                        LOGGER.debug("time: {}ms", System.currentTimeMillis() - time);
                        if (response == null) {
                            throw new RuntimeException("response is null");
                        }
                        // 返回 RPC 响应结果
                        if (response.hasException()) {
                            throw response.getException();
                        } else {
                            return response.getResult();
                        }
                    }
                }
        );
    }
}
