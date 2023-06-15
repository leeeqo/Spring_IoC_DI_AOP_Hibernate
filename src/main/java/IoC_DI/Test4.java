package IoC_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        // ссылка на один и тот же объект
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);
        System.out.println("Ссылка на один и тот же объект? - " + (myDog == yourDog) );

        context.close();
    }
}
