package com.damian.hms.repository;

import com.damian.hms.entity.Student;
import com.damian.hms.util.FactoryConfiguration;
import com.damian.hms.util.GetAlert;
import javafx.scene.control.Alert;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Optional;

public class StudentRepo {
    private Session session;
    public StudentRepo(){
        session = FactoryConfiguration.getInstance().getSession();
    }
    public boolean add(Student student){
        session.beginTransaction();
        try {
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in StudentRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }

        return false;
    }

    public boolean update(Student student) {
        session.beginTransaction();
        try {
            session.update(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in StudentRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }

        return false;
    }

    public boolean delete(String s) {
        session.beginTransaction();
        try {
            Student student = session.get(Student.class, s);
            session.delete(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in StudentRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }

        return false;
    }

    public ArrayList<Student> getAll() {
        session.beginTransaction();
        try {
            ArrayList<Student> students = (ArrayList<Student>) session.createQuery("from Student").list();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in StudentRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }

        return null;
    }

    public Optional<Student> search(String s) {
        session.beginTransaction();
        try {
            Student student = session.get(Student.class, s);
            return student==null?Optional.empty():Optional.of(student);
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in StudentRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }
        return Optional.empty();
    }
}
