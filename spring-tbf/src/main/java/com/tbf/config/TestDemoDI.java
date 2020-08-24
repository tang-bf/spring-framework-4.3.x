package com.tbf.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemoDI {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        B bean = classPathXmlApplicationContext.getBean(B.class);
        A beanA = classPathXmlApplicationContext.getBean(A.class);
        System.out.println(bean);
        System.out.println(beanA);
    }
}
