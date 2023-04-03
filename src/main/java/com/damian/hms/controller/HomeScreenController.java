package com.damian.hms.controller;

import com.damian.hms.dto.LoginDetails_DTO;
import com.damian.hms.service.impl.LoginDetailsServiceImpl;
import com.damian.hms.service.util.GetAlert;
import com.damian.hms.service.util.ServiceFactory;
import com.damian.hms.service.util.ServiceTypes;
import com.damian.hms.validator.ValidateTypes;
import com.damian.hms.validator.Validator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class HomeScreenController implements Initializable {
    public Label dateAndTime;
    public TextField t1;
    public TextField t2;
    public JFXButton lb;
    public JFXCheckBox sp;
    public JFXTextField t3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t3.setVisible(false);
    }


    public void t1OnAction(ActionEvent actionEvent) {
        t2.requestFocus();
    }

    public void t2OnAction(ActionEvent actionEvent) {
        loginOnAction(actionEvent);
    }


    public void spOnAction(ActionEvent actionEvent) {

        if (sp.isSelected()) {
            t3.setText(t2.getText());
            t3.setVisible(true);
            t2.setVisible(false);
        } else {
            t3.setVisible(false);
            t2.setVisible(true);
        }

    }

    public void loginOnAction(ActionEvent actionEvent) {
        LoginDetailsServiceImpl ls = ServiceFactory.getService(ServiceTypes.LoginDetailsService);/*
        boolean add = ls.add(new LoginDetails_DTO(t1.getText(), t2.getText()));
        if (add) {
            GetAlert.getInstance().showAlert("Login Success!", Alert.AlertType.INFORMATION);
        } else {
            GetAlert.getInstance().showAlert("Login Failed!", Alert.AlertType.ERROR);
        }*/


        Optional<LoginDetails_DTO> ld = ls.search(t1.getText());
        if(ld.get().getUserName().equals(t1.getText()) && ld.get().getPassword().equals(t2.getText())){
            GetAlert.getInstance().showAlert("Login Success!", Alert.AlertType.INFORMATION);
        }else{
            GetAlert.getInstance().showAlert("Login Failed!", Alert.AlertType.ERROR);
        }

    }






}
