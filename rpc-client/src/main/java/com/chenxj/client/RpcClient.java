package com.chenxj.client;

import com.chenxj.common.RpcDecoder;
import com.chenxj.common.RpcEncoder;
import com.chenxj.common.RpcRequest;
import com.chenxj.common.RpcResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenxj
 * @version $Id ServiceDiscovery.java, v 0.1 2017-09-11 20:40 chenxj Exp $$
 */
public class RpcClient extends SimpleChannelInboundHandler<RpcResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcClient.class);
    private String host;
    private int port;
    private BlockingQueue<RpcResponse> resQueue = new LinkedBlockingQueue<>();

    ChannelFuture future;

    private RpcResponse response;

    public RpcClient(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void channelRead0(ChannelHandlerContext ctx, RpcResponse response) throws Exception {
        this.response = response;

        resQueue.put(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("api caught exception", cause);
        ctx.close();
    }

    public RpcResponse send(RpcRequest request) throws Exception {
        future.channel().writeAndFlush(request).sync();

        RpcResponse response = resQueue.take();
        return response;
    }

    public void init() throws Exception {
        try {
            Bootstrap bootstrap = new Bootstrap();
            EventLoopGroup group = new NioEventLoopGroup(1024);
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new RpcEncoder(RpcRequest.class));
                            pipeline.addLast(new RpcDecoder(RpcResponse.class));
                            pipeline.addLast(RpcClient.this); // 处理 RPC 响应
                        }
                    })
                    .option(ChannelOption.SO_KEEPALIVE, true);

            future = bootstrap.connect(host, port).sync();

        } finally {


        }
    }
}
