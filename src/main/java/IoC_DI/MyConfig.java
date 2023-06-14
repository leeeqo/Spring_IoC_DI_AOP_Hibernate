package spring_introduction;

import org.springframework.context.annotation.*;


@Configuration
// @ComponentScan("spring_introduction") way 1 - scan package
// way 2 - throw away all the @Component
@PropertySource("classpath:myApp.properties")
public class MyConfig {

    @Bean
    @Scope("prototype")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    @Scope("singleton")
    public Person personBean() {
        return new Person(catBean());
    }
}
