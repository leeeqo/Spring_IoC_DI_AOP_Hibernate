package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* getabc*())") //abc - for 2.9
    public void allGetMethods() {}

    @Pointcut("execution(* addabc*(..))") //abc - for 2.9
    public void allAddMethods() {}
}
