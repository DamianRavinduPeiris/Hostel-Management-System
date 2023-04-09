package com.damian.hms.service.util;

import com.damian.hms.service.impl.LoginDetailsServiceImpl;
import com.damian.hms.service.impl.RoomDetailsServiceImpl;
import com.damian.hms.util.GetAlert;
import javafx.scene.control.Alert;

public class ServiceFactory {
    public static <T> T getService(ServiceTypes serviceTypes){
        switch (serviceTypes){
            case LoginDetailsService:
                return (T) new LoginDetailsServiceImpl();
            case RoomDetailsService:
                return (T) new RoomDetailsServiceImpl();
            default:
              GetAlert.getInstance().showAlert("Invalid Service Type!", Alert.AlertType.ERROR);
        }
        return null;

    }
}
