package com.laoli.bazooka.transaction.controller;

import com.laoli.bazooka.gc.entity.Greeting;
import com.laoli.bazooka.transaction.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class TestController {


    @Autowired
    private TestService testService;

    @RequestMapping("/test/testValue")
    public void greeting() {
//        System.out.println("testStaticPubliceValue:"+testService.testStaticPubliceValue);
//
//        System.out.println("testStaticPriviteValue:"+testService.getTestStaticPriviteValue());


        System.out.println("testNonStaticPubliceValue:"+testService.testNonStaticPubliceValue);
        System.out.println("testNonStaticPubliceValue:"+testService.getTestNonStaticPubliceValue());

        System.out.println("testNonStaticPriviteValue:"+testService.getTestNonStaticPriviteValue());


//        System.out.println("testPubliceNewValue:"+testService.testPubliceNewValue);
//        System.out.println("testPriviteNewValue:"+testService.getTestPriviteNewValue());

        testService.test();
    }
}
