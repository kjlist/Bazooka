package com.laoli.bazooka.zk.config;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZkConfig {
    @Bean
    public CuratorFramework getFramework(){
        CuratorFramework c = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:9164")
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .connectionTimeoutMs(15 * 1000) //连接超时时间，默认15秒
                .sessionTimeoutMs(60 * 1000) //会话超时时间，默认60秒
                .namespace("arch") //设置命名空间
                .build();
        c.start();
        return c;
    }
}
