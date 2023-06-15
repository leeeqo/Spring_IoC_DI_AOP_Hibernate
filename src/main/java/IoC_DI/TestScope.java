package IoC_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog dog = context.getBean("dogBean", Dog.class);
        dog.say();

    }
}
