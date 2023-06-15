package IoC_DI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

//@Component("personBean")
@Scope("singleton")
public class Person {
    //@Autowired
    //@Qualifier("catBean")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    //@Autowired //(after 4.3ver we may not write this, but it's better to mark)
    //public Person(@Qualifier("dogBean") Pet pet) {
    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public Person() {
        System.out.println("Person constructor");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("setSurname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge");
        this.age = age;
    }

    //@Autowired
    public void setPet(Pet pet) {
        System.out.println("Class Person: set Pet");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
