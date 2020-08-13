import com.tbf.config.AppConfig;
import com.tbf.service.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//一直乱码  最后在跑testdemo里的vm options -Dfile.encoding=UTF-8 控制台中文乱码解决
public class TestDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        User bean = annotationConfigApplicationContext.getBean(User.class);
        AppConfig bean1 = annotationConfigApplicationContext.getBean(AppConfig.class);

    }
}
