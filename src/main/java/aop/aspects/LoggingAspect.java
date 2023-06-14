package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    // 2.7
    @Pointcut("execution(* get*())")
    private void allGetMethods() {}

    @Before("allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice");
    }

    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice");
    }

    /*// 2.6. Creating pointcut for all the methods except returnMag

    @Pointcut("execution(* aop.UniLibrary.*(..))")
    private void allMethodsUniLib() {}

    @Pointcut("execution(* aop.UniLibrary.returnMagazine())")
    private void returnMagazineUniLib() {}

     @Pointcut("allMethodsUniLib() && !returnMagazineUniLib()")
    private void allMethodsExceptReturnMagUniLib() {}

    @Before("returnMagazineUniLib()")
    public void beforeReturnMag() {
        System.out.println("beforeReturnMagazine");
    }

    @Before("allMethodsExceptReturnMagUniLib()")
    public void beforeAllMethodsExceptReturnMag() {
        System.out.println("beforeAllMethodsExceptReturnMag");
    }*/

    /* 2.6
    @Pointcut("execution(* aop.UniLibrary.get*())")
    private void allGetMethodsUniLibrary() {}

    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void allReturnMethodsUniLibrary() {}

    @Pointcut("allGetMethodsUniLibrary() || allReturnMethodsUniLibrary()")
    private void allGetReturnMethodsUniLibrary() {}

    @Before("allGetMethodsUniLibrary()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: writing Log #1");
    }

    @Before("allReturnMethodsUniLibrary()")
    public void beforeReturnLoggingAdvice() {
        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
    }

    @Before("allGetReturnMethodsUniLibrary()")
    public void beforeGetReturnLoggingAdvice() {
        System.out.println("beforeAddReturnLoggingAdvice: writing Log #3");
    }*/

    /* 2.5
    // To avoid copy-paste of pointcut:
    @Pointcut("execution(* get*())")
    private void allGetMethods() {}

    // AspectJ Pointcut expression language
    //      -> pointcut
    //@Before("execution(* get*())")
    @Before("allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLogAdvice");
    }

    //@Before("execution(* get*())")
    @Before("allGetMethods()")
    public void beforeGetScurityAdvice() {
        System.out.println("beforeGetSecAdvice");
    }*/

    /*@Before("execution(public * returnBook(String))")
    public void beforeReturnBookString() {
        System.out.println("beforeReturnBook with String param: try to return book");
    }

    @Before("execution(* returnBook(aop.Book, ..))")
    public void beforeReturnBook() {
        System.out.println("beforeReturnBook: try to return book");
    }*/
}
