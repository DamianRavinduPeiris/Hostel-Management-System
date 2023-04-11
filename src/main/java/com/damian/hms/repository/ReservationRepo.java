package com.damian.hms.repository;

import com.damian.hms.entity.Reservation;
import com.damian.hms.util.FactoryConfiguration;
import com.damian.hms.util.GetAlert;
import javafx.scene.control.Alert;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepo {
    private final Session session;

    public ReservationRepo() {
        session = FactoryConfiguration.getInstance().getSession();

    }

    public boolean add(Reservation reservation) {
        session.beginTransaction();
        try {
            session.save(reservation);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in Reservation repo : " + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }
        return false;

    }


    public ArrayList<String> getStudentIds(String roomId) {
        session.beginTransaction();
        try {
            List studentIds = session.createQuery("SELECT r.student.id FROM Reservation r WHERE r.room.id = :roomId").setParameter("roomId", roomId).list();
            session.getTransaction().commit();
            session.close();
            return (ArrayList<String>) studentIds;
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in Reservation repo : " + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }
        return null;

    }
 /*   public ArrayList<String> getReservationIds(){
        session.beginTransaction();
        ArrayList<String> reservationIds = null;
        try {
            reservationIds = (ArrayList<String>) session.createQuery("select reservationId from Reservation").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in Reservationrepo : "+e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }
        return reservationIds;
    }*/
}
