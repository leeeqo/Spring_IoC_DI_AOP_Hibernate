package IoC_DI;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("dogBean")
public class Dog implements Pet{

    public Dog() {
        System.out.println("Dog constructor");
    }
    public void say() {
        System.out.println("Bow-Wow");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Dog: Init Method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Dog: Destroy Method");
    }
}
