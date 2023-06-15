package aop.aspects;

import aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudLogAdvice() {
        System.out.println("beforeGetStudLogAdvice");
    }

    @AfterReturning(pointcut = "execution(* getStudents())",
                    returning = "students")
    public void afterReturningGetStudLogAdvice(JoinPoint joinpoint, List<Student> students) {

        // Changing result of getStudents()
        Student first = students.get(0);
        first.setNameSurname("Mr. Nobody");
        first.setCourse(1);
        first.setAvgGrade(0.0);

        System.out.println("afterReturningGetStudLogAdvice");
    }

    @AfterThrowing(pointcut = "execution(* getStudents())",
                   throwing = "exception")
    public void afterThrowingGetStudLogAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("afterThrowingGetStudLogAdvice");
        System.out.println("Exception = " + exception);
    }

    @After("execution(* getStudents())")
    public void afterGetStudLogAdvice(JoinPoint joinPoint) {
        System.out.println("afterGetStudLogAdvice");
    }
}

