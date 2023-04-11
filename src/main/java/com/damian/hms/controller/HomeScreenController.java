package com.damian.hms.controller;

import com.damian.hms.dto.LoginDetails_DTO;
import com.damian.hms.service.impl.LoginDetailsServiceImpl;
import com.damian.hms.service.util.ServiceFactory;
import com.damian.hms.service.util.ServiceTypes;
import com.damian.hms.util.Animator;
import com.damian.hms.util.GetAlert;
import com.damian.hms.util.NavigateTypes;
import com.damian.hms.util.Navigator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class HomeScreenController implements Initializable {

    public TextField t1;
    public TextField t2;

    public JFXCheckBox sp;
    public JFXTextField t3;

    public ImageView image;
    public JFXButton lb;

    public ImageView i1;
    public Label l1;
    public Label l2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t3.setVisible(false);

        Platform.runLater(() -> {
            Node[] nodes = {t1, t2, sp, t3, lb,i1,l1,l2};
            for (Node n : nodes) {
                Animator.getInstance().setLightSpeedIn(n);

            }


        });

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
        LoginDetailsServiceImpl ls = ServiceFactory.getService(ServiceTypes.LoginDetailsService);
      /*  boolean add = ls.add(new LoginDetails_DTO("U001",t1.getText(), t2.getText()));
        if (add) {
            GetAlert.getInstance().showAlert("Login Success!", Alert.AlertType.INFORMATION);
        } else {
            GetAlert.getInstance().showAlert("Login Failed!", Alert.AlertType.ERROR);
        }*/

        Optional<LoginDetails_DTO> ld = ls.search("U001");
        if (ld.get().getUserName().equals(t1.getText()) && ld.get().getPassword().equals(t2.getText())) {
            Navigator.navigate((Stage) t2.getScene().getWindow(), NavigateTypes.DASHBOARD);
        } else {
            GetAlert.getInstance().showAlert("Invalid Credentials!", Alert.AlertType.ERROR);
        }


    }


}
