package com.tbf.config;
/**
 * Full @Configuration和lite @Bean mode，
 * spring 5版本中增加了
 * @Configuration(proxyBeanMethods = false)
 * 默认是true，需要显示改为false才算是Lite模式
 */

import com.tbf.service.Order;
import com.tbf.service.Power;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tbf")
public class AppConfig {
    @Bean
    public Order getOrder(){
        System.out.println("注入");
        return new Order();
    }
    @Bean
    public Power getPower(){
        getOrder();//此时不会再new  一个order出来
        return new Power();
    }
}
