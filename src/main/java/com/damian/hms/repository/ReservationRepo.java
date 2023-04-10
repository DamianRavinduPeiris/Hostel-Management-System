package com.damian.hms.repository;

import com.damian.hms.entity.Reservation;
import com.damian.hms.util.FactoryConfiguration;
import com.damian.hms.util.GetAlert;
import javafx.scene.control.Alert;
import org.hibernate.Session;

import java.util.ArrayList;

public class ReservationRepo {
    private Session session;
    public ReservationRepo(){
        session = FactoryConfiguration.getInstance().getSession();

    }
    public boolean add(Reservation reservation){
        session.beginTransaction();
        try {
            session.save(reservation);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in Reservationrepo : "+e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }
        return false;

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
