import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author duanbochao
 * @creat 2019/7/17
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = ctx.getBeanDefinitionNames();
        for (String s : names) {
            System.out.println(s);
        }

    }
}
