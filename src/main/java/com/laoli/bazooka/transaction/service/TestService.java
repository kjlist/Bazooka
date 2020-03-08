package com.laoli.bazooka.transaction.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
//@Transactional
public class TestService {
    //@Transactional加了之后就会启动mysql驱动，点解？

    @Value("${test.value1}")
    public String testNonStaticPubliceValue;

    @Value("${test.value1}")
    private String testNonStaticPriviteValue;


    public static String testStaticPubliceValue;

    private static String testStaticPriviteValue;



    public String testPubliceNewValue = new String("testPubliceNewValue");

    private String testPriviteNewValue = new String("testPriviteNewValue");


//    @Value("${test.value}")
//    public static String testStaticValue;

//    @Value("${test.value2}")
//    public void setTestStaticValue(String value){
//        TestService.testStaticValue = value;
//    }



    @Transactional(rollbackFor = Throwable.class)
    public void test() {
        System.out.println("test1"+this.testNonStaticPubliceValue);
        System.out.println("test2"+testNonStaticPubliceValue);

    }


    public String getTestNonStaticPriviteValue() {
        return testNonStaticPriviteValue;
    }

    public void setTestNonStaticPriviteValue(String testNonStaticPriviteValue) {
        this.testNonStaticPriviteValue = testNonStaticPriviteValue;
    }

    public static String getTestStaticPriviteValue() {
        return testStaticPriviteValue;
    }

    public static void setTestStaticPriviteValue(String testStaticPriviteValue) {
        TestService.testStaticPriviteValue = testStaticPriviteValue;
    }

    public String getTestPriviteNewValue() {
        return testPriviteNewValue;
    }

    public void setTestPriviteNewValue(String testPriviteNewValue) {
        this.testPriviteNewValue = testPriviteNewValue;
    }

    public String getTestNonStaticPubliceValue() {
        return testNonStaticPubliceValue;
    }

    public void setTestNonStaticPubliceValue(String testNonStaticPubliceValue) {
        this.testNonStaticPubliceValue = testNonStaticPubliceValue;
    }
}
