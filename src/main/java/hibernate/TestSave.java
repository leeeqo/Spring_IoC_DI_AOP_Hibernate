package hibernate;

//import hibernate.entity.HibernateUtilities_5;
import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestSave {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Employee employee = new Employee("John", "Russel", "KN IT", 500);

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
