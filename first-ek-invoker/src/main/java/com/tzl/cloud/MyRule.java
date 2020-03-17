package com.tzl.cloud;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义ribbon 负载的rule规则
 */
public class MyRule implements IRule{

    ILoadBalancer ib;

    public MyRule(){}

    public MyRule(ILoadBalancer ib){
        this.ib = ib;
    }
    @Override
    public Server choose(Object o) {
        List<Server> serverList = ib.getAllServers();
        System.out.println("这个是自定义服务器规则类---");
        for (Server server : serverList){
            System.out.println("---" + server.getHostPort());
        }
        return serverList.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.ib = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.ib;
    }
}
