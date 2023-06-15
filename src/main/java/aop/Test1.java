package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibraryBean", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.getMagazine();
        Book book = context.getBean("bookBean", Book.class);
        uniLibrary.addBook("Pershin", book);
        uniLibrary.addMagazine();

        //SchoolLibrary schlibrary = context.getBean("schoolLibraryBean", SchoolLibrary.class);
        //schlibrary.getBook();
        //schlibrary.getMagazine();

        context.close();
    }
}
