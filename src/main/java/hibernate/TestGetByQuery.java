package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestGetByQuery {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //String query = "from Employee";
            String query = "from Employee where salary > 1000";
            List<Employee> result = session.createQuery(query).list();

            for (Employee e : result) {
                System.out.println(e);
            }

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
