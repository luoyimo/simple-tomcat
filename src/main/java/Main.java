import javax.annotation.Resource;
import java.lang.annotation.Annotation;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 15:36 2018/5/29 0029
 */
@Resource
public class Main {
    public static void main(String[] args) {
        Annotation[] annotations = Main.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }
    }
}
