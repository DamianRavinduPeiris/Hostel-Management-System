package com.damian.hms.controller;

import com.damian.hms.dto.LoginDetails_DTO;
import com.damian.hms.service.impl.LoginDetailsServiceImpl;
import com.damian.hms.service.util.ServiceFactory;
import com.damian.hms.service.util.ServiceTypes;
import com.damian.hms.util.Animator;
import com.damian.hms.util.GetAlert;
import com.damian.hms.validator.ValidateTypes;
import com.damian.hms.validator.Validator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
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

import static com.damian.hms.validator.ValidateTypes.PASSWORD;
import static com.damian.hms.validator.ValidateTypes.USERNAME;

public class CredentialManagerController implements Initializable {
    public AnchorPane ap;
    public Label l1;
    public JFXTextField t1;
    public JFXButton ub;
    public JFXPasswordField t2;
    public JFXTextField t3;
    public JFXCheckBox sp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t3.setVisible(false);
        Node[] nodes = {l1,t1,ub,t2,sp};
        for(Node n : nodes){
            Animator.getInstance().setLightSpeedIn(n);
        }

    }
    public void t1OnAction(ActionEvent actionEvent) {
        t2.requestFocus();
    }

    public void ubOnAction(ActionEvent actionEvent) {
        boolean b1 = Validator.check(t1.getText(), USERNAME);
        if(b1){
            boolean b2 = Validator.check(t2.getText(), PASSWORD);
            if(b2){
                LoginDetailsServiceImpl ls = (LoginDetailsServiceImpl) ServiceFactory.getService(ServiceTypes.LoginDetailsService);
                boolean b = ls.update(new LoginDetails_DTO("U001",t1.getText(), t2.getText()));
                if(b) {
                    GetAlert.getInstance().showAlert("Credentials Updated Successfully!", Alert.AlertType.INFORMATION);
                }else{
                    GetAlert.getInstance().showAlert("Credentials Update Failed!", Alert.AlertType.ERROR);
                }

            }else{
                GetAlert.getInstance().showAlert("Invalid Password!", Alert.AlertType.ERROR);
            }
        }else{
            GetAlert.getInstance().showAlert("Invalid Username!", Alert.AlertType.ERROR);
        }

    }

    public void t2OnAction(ActionEvent actionEvent) {
        ubOnAction(actionEvent);
    }


    public void spOnAction(ActionEvent actionEvent) {
        if(sp.isSelected()){
            t3.setText(t2.getText());
            t2.setVisible(false);
            t3.setVisible(true);
        }else{
            t3.setVisible(false);
            t2.setVisible(true);
        }

    }
}
