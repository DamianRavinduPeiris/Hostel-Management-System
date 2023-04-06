package com.damian.hms.controller;

import com.damian.hms.dto.LoginDetails_DTO;
import com.damian.hms.service.impl.LoginDetailsServiceImpl;
import com.damian.hms.service.util.ServiceFactory;
import com.damian.hms.service.util.ServiceTypes;
import com.damian.hms.util.Animator;
import com.damian.hms.util.GetAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CredentialManagerController implements Initializable {
    public AnchorPane ap;
    public Label l1;
    public JFXTextField t1;
    public JFXButton ub;
    public JFXPasswordField t2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = {l1,t1,ub,t2};
        for(Node n : nodes){
            Animator.getInstance().setLightSpeedIn(n);
        }

    }
    public void t1OnAction(ActionEvent actionEvent) {
        t2OnAction(actionEvent);
    }

    public void ubOnAction(ActionEvent actionEvent) {
        LoginDetailsServiceImpl ls = (LoginDetailsServiceImpl) ServiceFactory.getService(ServiceTypes.LoginDetailsService);
        boolean b = ls.update(new LoginDetails_DTO("U001",t1.getText(), t2.getText()));
        if(b) {
            GetAlert.getInstance().showAlert("Credentials Updated Successfully!", Alert.AlertType.INFORMATION);
        }else{
            GetAlert.getInstance().showAlert("Credentials Update Failed!", Alert.AlertType.ERROR);
        }
    }

    public void t2OnAction(ActionEvent actionEvent) {
        ubOnAction(actionEvent);
    }


}
