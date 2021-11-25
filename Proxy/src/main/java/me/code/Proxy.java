package me.code;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Proxy {

    private final int port;
    private final EventLoopGroup workerGroup;
    private final EventLoopGroup bossGroup;

    public Proxy(int port) {
        this.port = port;
        this.workerGroup = new NioEventLoopGroup();
        this.bossGroup = new NioEventLoopGroup();
    }

    public void start(){

        ServerBootstrap bootstrap = new ServerBootstrap();

        try {
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ProxyInitializer(this))
                    .bind(this.port).sync().channel().closeFuture().sync();
        } catch (Exception exception){
            exception.printStackTrace();
        }

    }
    public EventLoopGroup getWorkerGroup(){
        return workerGroup;
    }
}
