package sk.kosickaakademia.damianmatysko.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kosickaakademia.damianmatysko.entity.Nationality;
import sk.kosickaakademia.damianmatysko.entity.People;

public class CreateNationality {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Nationality.class)
                .addAnnotatedClass(People.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            Nationality nationality = new Nationality("Slovakia","49,035 km²");
            session.beginTransaction();
            session.save(nationality);
            session.getTransaction().commit();
            System.out.println("Success!!!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
