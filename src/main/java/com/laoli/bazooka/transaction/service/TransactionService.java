package com.laoli.bazooka.transaction.service;


import com.laoli.bazooka.transaction.dao.UserDao;
import com.laoli.bazooka.transaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TransactionService {

    @Resource
    private UserDao userDao;

    @Resource
    private PropagationService propagationService;

    @Transactional
    public void Example1(User user) {
        userDao.createUser(user);
        propagationService.required();
    }

    @Transactional
    public void Example2(User user) {
        userDao.createUser(user);
        try {
            propagationService.required();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Transactional
    public void Example3(User user) {
        userDao.createUser(user);
        propagationService.requiresNew();
    }


    @Transactional
    public void Example4(User user) {
        userDao.createUser(user);
        try {
            propagationService.requiresNew();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Transactional(rollbackFor = Exception.class)
//@Transactional()
public void Example11(User user) throws Exception {
        userDao.createUser(user);
        propagationService.requiredNotRunTime();
    }


    @Transactional(readOnly = true)
public void Example0(User user) throws Exception {
        userDao.createUser(user);
    }



    @Transactional
    public void Example66(User user) {
        userDao.createUser(user);
        if (user.getUsername().equals("hello")){
            throw new RuntimeException("Example66");
        }
//        userDao.createUser(user);
    }

    public void Example6(User user) {
        Example66(user);
    }

}
