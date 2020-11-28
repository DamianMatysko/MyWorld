package sk.kosickaakademia.damianmatysko.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kosickaakademia.damianmatysko.entity.Nationality;
import sk.kosickaakademia.damianmatysko.entity.People;

public class CreatePeople {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Nationality.class)
                .addAnnotatedClass(People.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 1;
            Nationality nationality = session.get(Nationality.class, id);
            People people1 = new People("Jozko Vajda", "7. 11. 1995");
            People people2 = new People("Duri Traktorista", "6. 3. 1979");
            nationality.add(people1);
            nationality.add(people2);
            session.save(people1);
            session.save(people2);

            session.getTransaction().commit();
            System.out.println("Success!!!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
