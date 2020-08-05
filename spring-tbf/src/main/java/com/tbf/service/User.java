package com.tbf.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class User  implements InitializingBean {
    public User() {
        System.out.println("user constructor");
    }
    @PostConstruct  //  javax.annotation;  javaconfig
    public void  init(){
        System.out.println("PostConstruct -------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" InitializingBean  --------");
    }
    //   PostConstruct   和实现了InitializingBean 的afterPropertiesSet 执行顺序是不同的，一个是
   // CommonAnnotationBeanPostProcessor  extends  BeanPostProcessor 放在后置处理器调用，一个是invokeinit
    //CommonAnnotationBeanPostProcessor还能处理@Resource注解
}
