package hibernate;

//import hibernate.entity.HibernateUtilities_5;
import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Employee employee = new Employee("Otto", "Mannergeim", "HR", 2000);

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee currEmployee = (Employee) session.get(Employee.class, employee.getId());
            session.getTransaction().commit();
            sou;
        }
        finally {
            factory.close();
        }
    }
}
