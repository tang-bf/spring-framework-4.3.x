package springmvctestdemo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: tbhStudy
 * @Package: springmvctestdemo.test
 * @ClassName: MyController
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 23:06
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 23:06
 * @UpdateRemark:
 * @Version: 1.0
 */

/**
 * springmvc 大概流程
 * 1:首先方法进入：doDispatch
 * 2:checkMultipart() 判断当前请求是否有文件
 * 3:getHandler（） ：通过HandleMapping去找一个Controller对象
 * 	3.1:扩展点1：HandleMapping
 * 	3.2: Spring boot 扩展Spring mvc 其中就扩展了 HandleMapping 去解析静态资源
 * 4: getHandlerAdapter（）: 根据你controller的类型去找一个适配器
 * 	4.1:  因为Controller有很多种不同的注册方式 所以需要不同的适配器
 * 	4.2:扩展点2：HandlerAdapter
 * 5:handle() : 执行Controller逻辑并且进行视图裁决（判断是要重定向还是转发还是响应页面）
 * 	5.1invokeForRequest()：执行方法的全部逻辑
 * 	5.2：首先给参数赋值
 * 		5.2.1:参数赋值的扩展点：HandlerMethodArgumentResolver
 * 	5.3：调用invoke（）指定方法
 * 6:setResponseStatus（）设置ResponseStatus响应状态码 对标：@ResponseStatus注解
 * 7：handleReturnValue（） 进行视图裁决
 * 	7.1:扩展点:returnValueHandlers 通过这个对象来进行判断接下来视图怎么做、
 * 8：handler.handleReturnValue（） 对冲顶于返回值处理（判断是否需要响应还是需要重定向）
 * 	8.1： 如果是@ResponseBody 注解又有一个扩展点:HttpMessageConverter
 * 9:getModelAndView() 重新封装一个ModelAndView对象
 * 	9.1：如果不需要渲染视图（如果是重定向 || 响应视图的话） 就会返回null
 * 	9.2: mavContainer.isRequestHandled() 判断是否需要重定向或响应
 * 	9.3: 同时会把model里面的参数放到request.setAttribute（说明model的作用域是request作用域）
 * 10：processDispatchResult（）：开始做视图渲染
 * 	10.1:判断是否需要响应异常视图
 * 	10.2:扩展点：ViewResolver
 * 	10.2：拿到视图名称 封装一个视图对象 进行forward
 * ....
 */
@Controller
@ControllerAdvice
public class MyController   {
    @RequestMapping("/query.do")
    @ResponseBody
    //如果直接返回string spring是可以直接解析的StringHttpMessageConverter ，如果返回map，则需要配置解析
    //有xml配置的，也可通过appconfig implements WebMvcConfigurer 重写 configureMessageConverters
    public  Map<String,String>  query(String name ){
        System.out.println("query1111 ---");
        Map<String,String> map = new HashMap<String,String>();
        System.out.println(MyController.class.getResource("/").getPath());
        map.put("hello","success");
        return map;
    }
    @RequestMapping("/queryString.do")
    @ResponseBody
    //如果直接返回string spring是可以直接解析的StringHttpMessageConverter ，如果返回map，则需要配置解析
    //有xml配置的，也可通过appconfig implements WebMvcConfigurer 重写 configureMessageConverters
    public  String queryJson(String name ){
        System.out.println("query222 ---");

        return "this is string ";
    }
    @RequestMapping("/queryView.do")
    //视图跳转还是直接渲染  ViewNameMethodReturnValueHandler  supportsReturnType(returnType)) (void.class == paramType || CharSequence.class.isAssignableFrom(paramType));
    public  String queryView(String name ){
        System.out.println("query222 ---");

        return "test";
    }
    /**
     * 跳转的五种方法
     *
     * 第一种：返回值跳转
     * 注：返回值就是视图名称
     *
     * @RequestMapping(path = "/testUser")
     * public String testUser(){
     *     System.out.println("跳转");
     *     return "success";
     * }
     *
     *
     * 第二种：无返回值
     * 注：方法名就是视图名
     *
     * @RequestMapping(path = "/testVoid")
     * public void testVoid(){
     *     System.out.println("跳转");
     * }
     *
     * 第三种：原声Servlet
     * 注：要写全路径
     *
     * @RequestMapping(path = "/testRequest")
     * public void testRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
     *     System.out.println("跳转");
     *     //request.getRequestDispatcher("/users/success.jsp").forward(request,response);
     *     System.out.println(request.getContextPath());
     *     response.sendRedirect(request.getContextPath()+"/users/success.jsp");
     * }
     *
     * 第四种：返回ModelAndView
     * 注：第一种和第二种的底层也是这个实现的
     *
     * @RequestMapping(path = "/testModelAndView")
     * public ModelAndView testModelAndView(){
     *     ModelAndView mv = new ModelAndView();
     *     mv.addObject("user","用户");  //保存数据到request域中(注：key:value)
     *     System.out.println("跳转");
     *     mv.setViewName("success");//跳转页面
     *     return mv;
     * }
     *
     *
     * 第五种：关键字跳转
     * 注：关键字：forward转发 redirect重定向
     *
     * @RequestMapping(path = "/testKeyword")
     * public String testKeyword(){
     *     return "forward:/users/success.jsp";//转发
     *     //return "redirect:/index.jsp";//重定向
     * }
     */
}
