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
@Controller
@ControllerAdvice
public class MyController   {
    @RequestMapping("/query.do")
    @ResponseBody
    //如果直接返回string spring是可以直接解析的StringHttpMessageConverter ，如果返回map，则需要配置解析
    //有xml配置的，也可通过appconfig implements WebMvcConfigurer 重写 configureMessageConverters
    public  Map<String,String>  query(String name ){
        System.out.println("query ---");
        Map<String,String> map = new HashMap<String,String>();
        System.out.println(MyController.class.getResource("/").getPath());
        map.put("hello","success");
        return map;
    }
}
