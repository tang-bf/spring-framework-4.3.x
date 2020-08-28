package springmvctestdemo.test;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @ProjectName: tbhStudy
 * @Package: springmvctestdemo.test
 * @ClassName: AppConfig
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 23:02
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 23:02
 * @UpdateRemark:
 * @Version: 1.0
 */

/** spring会判断是不是合成类 合成方法(合成注释摘自百度 隐秘而诡异的Java合成方法http://blog.iderzheng.com/java-synthetic-methods/ )
 * Java程序里其实有很多我们看不到的代码，这些代码由Java编译器在编译过程中生成帮助程序更准确地运行。
 * 本文就来深入了解一下由编译器加入到Java代码中的方法(Method)，特别是合成方法(Synthetic Method)。
 * 合成成员(Synthetic Member)在JVM细则里可以找到简单的定义
 * A class member that does not appear in the source code
 * must be marked using a Synthetic attribute, or else it must have its ACC_SYNTHETIC flag set.
 *isSynthetic 内部类 类的flags包含ACC_SYNTHETIC。匿名内部类字节码中没有ACC_SYNTHETIC标记，说明其与 synthetic 无关。
 *lambda表达式没有通过内部类实现，而是通过invokedynamic这个指令解决的。
 * xml方式配置spring mvc
 * 编写web.xml；注册listener、注册servlet、注册servlet-mapping
 * 编写spring-mvc.xml
 * 执行servlet规范：
 * 在"根目录/resources/META-INF/services/"添加配置文件javax.servlet.ServletContainerInitializer
 * 自定义一个类实现spring提供的WebApplicationInitializer接口，实例化&初始化spring容器
 * 自定义controller类和业务逻辑
 * 打包部署到web容器(通常使用tomcat)
 *
 * 零xml配置  内置tomcat 启动spring mvc
 * AppConfig 代替spring-mvc.xml
 * 注解方式驱动springmvc，等同于<annotation:driver>
 * 不加不会解析WebMvcConfigurer接口
 *  如果不加@EnableWebMvc，就要改成extends WebMvcConfigurationSupport
 *  因为@EnableWebMvc  import 的DelegatingWebMvcConfiguration 也是extends WebMvcConfigurationSupport
 *
 *  springmvc 零配置方式加载handlemapping viewresovver 是以@bean的方式注册到spring容器中，初始化mvc的一些组件
 *  通过dispatcherservlet.proprties中的key value获取合适的组件
 */
@Component
@ComponentScan("springmvctestdemo")
//加上注解mvc实质生效
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
//    @Bean
//    public HttpMessageConverter get(){
//        return new FastJsonHttpMessageConverter();
//    }
//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver internalResourceViewResolver = (InternalResourceViewResolver) new UrlBasedViewResolver();
//        internalResourceViewResolver.setPrefix("/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
//        return internalResourceViewResolver;
//    }
//    @Bean("multipartResolver")//名字必须是这个，为什么？
//    public CommonsMultipartResolver commonsMultipartResolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        return commonsMultipartResolver;
//    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //底层调用的就是public UrlBasedViewResolverRegistration jsp(String prefix, String suffix) {
        //		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //		resolver.setPrefix(prefix);
        //		resolver.setSuffix(suffix);
        //		this.viewResolvers.add(resolver);
        //		return new UrlBasedViewResolverRegistration(resolver);
        //	}
        registry.jsp();

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

    }
    //// 配置消息转换器 这里用fastjson，
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.out.println("fast json ----");
        converters.add(new FastJsonHttpMessageConverter());

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
//    public static void main(String[] args) {
//        StringHttpMessageConverter
//    }
}
