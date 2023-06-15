package IoC_DI;

//@Component("catBean")
public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat constructor");
    }
    public void say() {
        System.out.println("Meow-Meow");
    }
}
