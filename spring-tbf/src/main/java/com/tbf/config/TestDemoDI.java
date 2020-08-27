package com.tbf.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 更新到2020版本后小齿轮
 * Autoscroll to Source -> Open Files with Single Click
 * Autoscroll from Source -> Always Select Opened File
 *
 * DI(依赖注入)一共有两种主要的变体，分别是基于构造方法的依赖注入和基于setter（setXxxx(…)）的依赖注入，
 * 不管是手动装配还是自动装配都是基于这两种方式或者变体方式来的；主要和变体，
 * 因为有的注入方式就不是这两种，而是这两种其中一种的变体方式；比
 * 如在一个类的属性上面加@Autowired，这种方式注入属性的方式就是利用了java的反射知识，
 * field.set(value,targetObject)
 * 所谓的setter其实和属性无关，
 * 一般的setter方法会对应一个属性，
 * 但是spring的基于setter的注入方式是不需要属性的，
 * 仅仅只需要一个setter方法
 */
public class TestDemoDI {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        B bean = classPathXmlApplicationContext.getBean(B.class);
        A beanA = classPathXmlApplicationContext.getBean(A.class);
        System.out.println(bean);
        System.out.println(beanA);
        //家里电脑下载运行成功
    }
}
