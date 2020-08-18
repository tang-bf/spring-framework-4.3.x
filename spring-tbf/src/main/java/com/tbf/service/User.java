package com.tbf.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 三种方法实现lifecyclecallback
 * Multiple lifecycle mechanisms configured for the same bean, with different initialization methods, are called as follows:
 *abstractAutowireCapableBeanFactory initializeBean 方法中执行commomannotationbeanpostprocessor 后在反射调用A执行invokeAwareMethods
 * Methods annotated with @PostConstruct
 * afterPropertiesSet() as defined by the InitializingBean callback interface
 * A custom configured init() method
 */

/**输出顺序
 * user constructor
 * 执行Aware接口方法
 * PostConstruct -------
 *  InitializingBean  init --------
 * custom init method
 *
 */
@Component
public class User  implements InitializingBean , ApplicationContextAware {
    public User() {
        System.out.println("user constructor");
    }
    @PostConstruct  //  javax.annotation;  javaconfig
    public void  init(){
        System.out.println("PostConstruct -------");
    }

    public void custominit(){
        System.out.println("custom init method");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" InitializingBean  init --------");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("执行Aware接口方法");
        //在populateBean 之后  由ApplicationContextAwareProcessor （beanpostprocessor）
        // 调用执行invokeAwareInterfaces 判断是ApplicationContextAware
        // 先commonannotation 后置之前接着 init lifecyclecallback 之前
    }
    //   PostConstruct   和实现了InitializingBean 的afterPropertiesSet 执行顺序是不同的，一个是
   // CommonAnnotationBeanPostProcessor  extends  BeanPostProcessor 放在后置处理器调用，一个是invokeinit
    //CommonAnnotationBeanPostProcessor还能处理@Resource注解
}
