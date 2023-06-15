package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bookBean")
public class Book {
    @Value(value="Leon")
    private String name;
    @Value(value="Besson")
    private String author;
    @Value(value="2000")
    private int yearOfRelease;

    public String getName() {
        return name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getAuthor() {
        return author;
    }
}
