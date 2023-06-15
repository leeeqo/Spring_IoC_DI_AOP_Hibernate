package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
@Order(1) // 2.7
public class LoggingAspect {

    // 2.7 - to make an order
    //@Pointcut("execution(* get*())")
    //private void allGetMethods() {}

    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) { //2.8

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());

        Object[] args = joinPoint.getArgs();
        if (methodSignature.getName().equals("addBook")) {
            for (Object obj : args) {
                if (obj instanceof Book) {
                    Book book = (Book) obj;
                    System.out.println("Book:");
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Name:" + book.getName());
                    System.out.println("Year of release: " + book.getYearOfRelease());
                }
                else if (obj instanceof String) {
                    String str = (String) obj;
                    System.out.println("Book is added by " + str);
                }
            }
        }



        System.out.println("beforeAddLoggingAdvice");
        System.out.println("------------------------------------");
    }

    //@Before("allGetMethods()")
    //public void beforeGetSecurityAdvice() {
    //    System.out.println("beforeGetSecurityAdvice");
    //}

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
