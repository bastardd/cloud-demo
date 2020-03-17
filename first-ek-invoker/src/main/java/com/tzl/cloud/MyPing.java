package com.tzl.cloud;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * 自定义ribbon 的Ping机制
 */
public class MyPing implements IPing{
    @Override
    public boolean isAlive(Server server) {
        System.out.println("自定义的Ping类，服务器的信息 ：" + server.getHostPort());
        return true;
    }
}
