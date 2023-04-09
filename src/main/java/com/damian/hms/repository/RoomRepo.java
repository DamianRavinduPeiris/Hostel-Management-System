package com.damian.hms.repository;

import com.damian.hms.entity.Room;
import com.damian.hms.util.FactoryConfiguration;
import com.damian.hms.util.GetAlert;
import javafx.scene.control.Alert;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Optional;

public class RoomRepo {
    private Session session;

    public RoomRepo(){
         session = FactoryConfiguration.getInstance().getSession();
    }
    public ArrayList<Room>getAll(){
        ArrayList<Room> rooms=null;
        session.beginTransaction();

        try {
             rooms = (ArrayList<Room>) session.createQuery("FROM Room").list();
        } catch (Exception e) {
            GetAlert.getInstance().showAlert("Error in RoomRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }
        return rooms;
    }

    public boolean add(Room room) {
        session.beginTransaction();
        try {
            session.save(room);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in RoomRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    public boolean update(Room room) {
        session.beginTransaction();
        try {
            session.update(room);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in RoomRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    public Room search(String s) {
        session.beginTransaction();
        Room room = null;
        try {
            room = session.get(Room.class, s);
        } catch (Exception e) {
            GetAlert.getInstance().showAlert("Error in RoomRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }
        return room;
    }

    public boolean delete(String id) {
        session.beginTransaction();
        try {
            session.delete(session.get(Room.class,id));
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            GetAlert.getInstance().showAlert("Error in RoomRepo :" + e.getLocalizedMessage(), Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }
}
