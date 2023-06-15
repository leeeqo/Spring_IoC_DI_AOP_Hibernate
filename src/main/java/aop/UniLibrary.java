package aop;

import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary extends AbstractLibrary{

    //@Override
    public void getBook() {
        System.out.println("Getting a book from UniLibrary");
        System.out.println("------------------------------------");
    }

    //public String returnBook(String name) {
    public void returnBook() {
        System.out.println("Returning the book from UniLibrary");
        System.out.println("------------------------------------");

        //return "ok";
    }

    public void getMagazine() {
        System.out.println("Getting a magazine from UniLibrary");
        System.out.println("------------------------------------");

    }

    public void returnMagazine() {
        System.out.println("Returning the magazine from UniLibrary");
        System.out.println("------------------------------------");

    }

    public void addBook(String personName, Book book) {
        System.out.println("Adding a book to UniLibrary");
        System.out.println("------------------------------------");

    }

    public void addMagazine() {
        System.out.println("Adding a magazine to UniLibrary");
        System.out.println("------------------------------------");

    }

    /*public String returnBook(Book book) {
        System.out.println("Returning the book: " + book.getName());
        return "ok";
    }*/
}
