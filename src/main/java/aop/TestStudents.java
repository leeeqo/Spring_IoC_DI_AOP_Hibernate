package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestStudents {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();

        try {
            List<Student> students = university.getStudents();
        }
        catch (Exception e) {
            System.out.println("Exception was caught");
        }

        context.close();
    }
}
