import com.tbf.config.A;
import com.tbf.config.AppConfig;
import com.tbf.config.B;
import com.tbf.config.TestImport;
import com.tbf.service.User;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//一直乱码  最后在跑testdemo里的vm options -Dfile.encoding=UTF-8 控制台中文乱码解决
public class TestDemo {
    static {
        //生成jdk动态代理类
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //生成cglib动态代理类   会有三个类  一个代理类  两个继承了fastclass的类  会为方法建立索引
        //已经拷贝到build目录下resources下
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\cglib");
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
               // = new AnnotationConfigApplicationContext(TestImport.class);
        User bean = annotationConfigApplicationContext.getBean(User.class);
        AppConfig bean1 = annotationConfigApplicationContext.getBean(AppConfig.class);
        /*A a = annotationConfigApplicationContext.getBean(A.class);
        System.out.println(a);
        B b = annotationConfigApplicationContext.getBean(B.class);
        System.out.println(b);*/

    }
}
