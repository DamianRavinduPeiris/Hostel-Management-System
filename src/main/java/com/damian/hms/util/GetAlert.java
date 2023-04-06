package com.damian.hms.util;

import javafx.scene.control.Alert;

public class GetAlert {
    public static Object AlertType;
    private static Alert a;
    private static GetAlert alert;
    private GetAlert(){
        a = new Alert(Alert.AlertType.INFORMATION);
    }

    public static GetAlert getInstance(){
     return alert==null?alert = new GetAlert():alert;
    }
    public static void showAlert(String msg, Alert.AlertType type){
        a.setContentText(msg);
        a.setAlertType(type);
        a.show();
    }
}
