package com.damian.hms.util;

import com.damian.hms.entity.LoginDetails;
import com.damian.hms.entity.Reservation;
import com.damian.hms.entity.Room;
import com.damian.hms.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().addProperties(PropertyInjector.injectProperties()).addAnnotatedClass(LoginDetails.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(Student.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

}
