package com.laoli.bazooka.zk.controller;

import com.laoli.bazooka.gc.entity.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ZkController {


    @Autowired
    private CuratorFramework curatorFramework;

    @RequestMapping("/create")
    public void create(String s) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().forPath("/hello",s.getBytes());
        String sb = "a";
        sb = sb +"ss";
    }
}
