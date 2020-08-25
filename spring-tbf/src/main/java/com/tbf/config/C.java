package com.tbf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {
    @Autowired
    D d;

    public void setD(D d) {
        System.out.println("使用这个注解，这个方法变得无效");
        System.out.println("这个方法甚至都不会调用");
        System.out.println("这种方法用的是field.set");
    }
}
