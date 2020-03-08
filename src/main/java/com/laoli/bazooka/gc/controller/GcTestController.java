package com.laoli.bazooka.gc.controller;

import com.laoli.bazooka.gc.entity.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class GcTestController {

    private List<Greeting> objListCache = new ArrayList<>();

    @RequestMapping("/greeting")
    public Greeting greeting() {
        Greeting greeting = new Greeting();
        if (objListCache.size() >= 100000) {
            log.info("clean the List!!!!!!!!!!");
            objListCache.clear();
        } else {
            objListCache.add(greeting);
        }
        return greeting;
    }
}
