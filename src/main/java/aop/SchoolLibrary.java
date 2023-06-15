package aop;

import org.springframework.stereotype.Component;

@Component("schoolLibraryBean")
public class SchoolLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("Getting a book from SchoolLibrary");
    }

    public void getMagazine() {
        System.out.println("Getting a mag from SchoolLibrary");
    }
}
