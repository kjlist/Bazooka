package com.laoli.bazooka.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropagationService {

    @Transactional
    public void required() {
        throw new NullPointerException("抛出异常1");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew() {
        throw new NullPointerException("抛出异常2");
    }

    @Transactional
    public void requiredNotRunTime() throws Exception {
        throw new Exception("抛出非运行时");
    }
}
