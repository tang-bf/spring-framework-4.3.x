import com.tbf.config.AppConfig;
import com.tbf.service.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        User bean = annotationConfigApplicationContext.getBean(User.class);
        AppConfig bean1 = annotationConfigApplicationContext.getBean(AppConfig.class);

    }
}
