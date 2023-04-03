package com.damian.hms.dao.util;

import com.damian.hms.dao.impl.LoginDetailsDAOIMPL;
import com.damian.hms.service.util.GetAlert;
import javafx.scene.control.Alert;

public class DaoFactory {
    public static <T> T getDao(DaoTypes daoTypes){
        switch (daoTypes){
            case LoginDetailsDAO:
                return (T)  new LoginDetailsDAOIMPL();
            default:
                GetAlert.getInstance().showAlert("Invalid DAO Type!", Alert.AlertType.ERROR);

        }
        return null;


    }

}
