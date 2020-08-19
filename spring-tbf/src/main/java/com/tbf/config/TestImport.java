package com.tbf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//@Configuration
@Import({A.class,B.class})
public class TestImport {
    //加不加/@Configuration 区别  tetsImport类进行代理增强，这个类主要测试configurationclasspostprocessor
    //解析import注解流程


}
