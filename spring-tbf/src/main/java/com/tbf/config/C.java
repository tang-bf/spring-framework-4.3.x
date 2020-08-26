package com.tbf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {
    //autowireMode 0 即为no
    // InstantiationAwareBeanPostProcessor 后置处理 AutoWiredAnnotationBeanPostProcessor 的内部类
    // AutowiredFieldElement AutowiredMethodElement  element.inject
    //  value = beanFactory.resolveDependency(desc
    //发现D的时候也是需要解析创建 object d对象的
    //也是要和c一样流程，同样走到属性填充，会applyPropertyValues(beanName, mbd, bw, pvs);
    //走到这里发现不需要属性填充，直接return
    //singletonfactories
    //singletonobjects 有了d  singletonfactories 移除了c
    @Autowired
    D d;

    public void setD(D d) {
        System.out.println("使用这个注解，这个方法变得无效");
        System.out.println("这个方法甚至都不会调用");
        System.out.println("这种方法用的是field.set");
    }
}
