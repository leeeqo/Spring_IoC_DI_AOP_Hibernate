package hibernate_2;

//import hibernate.entity.HibernateUtilities_5;
import hibernate_2.entity.Employee;
import hibernate_2.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Employee employee = new Employee("John", "Russel", "KN IT", 500);
        Detail detail = new Detail("Washington", "777", "abc@gmail.com");
        employee.setEmpDetail(detail);

        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
