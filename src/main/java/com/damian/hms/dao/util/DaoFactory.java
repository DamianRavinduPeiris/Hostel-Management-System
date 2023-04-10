package com.damian.hms.dao.util;

import com.damian.hms.dao.impl.LoginDetailsDAOIMPL;
import com.damian.hms.dao.impl.ReservationDAOIMPL;
import com.damian.hms.dao.impl.RoomDetailsDAOIMPL;
import com.damian.hms.dao.impl.StudentDAOIMPL;
import com.damian.hms.util.GetAlert;
import javafx.scene.control.Alert;

public class DaoFactory {
    public static <T> T getDao(DaoTypes daoTypes) {
        switch (daoTypes) {
            case LoginDetailsDAO:
                return (T) new LoginDetailsDAOIMPL();
            case RoomDetailsDAO:
                return (T) new RoomDetailsDAOIMPL();
            case StudentDAO:
                return (T) new StudentDAOIMPL();
            case ReservationDAO:
                return (T) new ReservationDAOIMPL();
            default:
                GetAlert.getInstance().showAlert("Invalid DAO Type!", Alert.AlertType.ERROR);

        }
        return null;


    }

}
