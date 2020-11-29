package sk.kosickaakademia.damianmatysko.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kosickaakademia.damianmatysko.entity.Nationality;
import sk.kosickaakademia.damianmatysko.entity.People;

public class UpdatePeople {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Nationality.class)
                .addAnnotatedClass(People.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int id = 2;
            People people= session.get(People.class, id);

            people.setFullName("Jozko Procko");
            session.update(people);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
