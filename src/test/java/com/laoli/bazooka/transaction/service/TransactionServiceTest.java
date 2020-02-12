package com.laoli.bazooka.transaction.service;


import com.laoli.bazooka.transaction.dao.UserDao;
import com.laoli.bazooka.transaction.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {

    @Resource
    private TransactionService transactionService;


    @Test
    public void Example1() {
        User user = new User();
        user.setUsername("vito1");
        transactionService.Example1(user);
    }

    @Test
    public void Example2() {
        User user = new User();
        user.setUsername("vito2");
        transactionService.Example2(user);
    }


    @Test
    public void Example3() {
        User user = new User();
        user.setUsername("vito3");
        transactionService.Example3(user);
    }


    @Test
    public void Example4() {
        User user = new User();
        user.setUsername("vito4");
        transactionService.Example4(user);
    }


    @Test
    public void Example11() throws Exception {
        User user = new User();
        user.setUsername("vito11");
        transactionService.Example11(user);
    }

    @Test
    public void Example0() throws Exception {
        User user = new User();
        user.setUsername("vito0");
        transactionService.Example0(user);
    }

    @Test
    public void Example6() throws Exception {
        User user = new User();
        user.setUsername("hello");
        transactionService.Example6(user);
    }

    @Test
    public void Example66() throws Exception {
        User user = new User();
        user.setUsername("hello");
        transactionService.Example66(user);
    }

}
