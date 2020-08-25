package com.tbf.config;

public class A {
  //  B b;//xml手动维护的时候，其实和属性无关，只是和set方法有关，所以属性可以不要，
    //可以把这个注释掉，参考setxxx方法实现验证
//    public A() {
//        System.out.println("A 的构造方法");
//    }

//    public void setB(B b) {
//        System.out.println("调用了setb");
//        this.b = b;
//
//    }
    //在spring当做是BeanUtils.getWriteMethodParameter  执行到writeMethod.invoke(getWrappedInstance(), value);
    public void setTtt(B b) {
        System.out.println("spring 找到符合的setter");
        System.out.println("和属性无关，甚至可以不要属性");
        System.out.println("可以直接调用，这个A里面就没有任何属性");

    }
}
