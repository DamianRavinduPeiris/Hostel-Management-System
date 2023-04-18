package com.damian.hms.repository;

import com.damian.hms.entity.LoginDetails;
import com.damian.hms.entity.Student;
import com.damian.hms.util.GetAlert;
import com.damian.hms.util.FactoryConfiguration;
import javafx.scene.control.Alert;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.Optional;

public class LoginRepo {
    private static Session session;

    public LoginRepo() {
        session = FactoryConfiguration.getInstance().getSession();
    }

    public boolean add(LoginDetails ld) {
        session.beginTransaction();
        try {
            session.save(ld);
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in Login repo : " + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }

        session.getTransaction().commit();
        return true;

    }

    public Optional<LoginDetails> search(String id) {
        session.beginTransaction();
        LoginDetails loginDetails = session.get(LoginDetails.class, id);
        session.getTransaction().commit();
        return loginDetails == null ? Optional.empty() : Optional.of(loginDetails);
    }

    public boolean update(LoginDetails loginDetails) {
        session.beginTransaction();

        try {
            session.update(loginDetails);
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in Login repo : " + e.getLocalizedMessage(), Alert.AlertType.ERROR);
            return false;
        }
        session.getTransaction().commit();
        return true;
    }
}
