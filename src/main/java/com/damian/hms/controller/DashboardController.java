package com.damian.hms.controller;

import com.damian.hms.util.Animator;
import com.damian.hms.util.Navigator;
import com.jfoenix.controls.JFXButton;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public ImageView image;
    public Label l1;
    public JFXButton ucButton;
    public ImageView i2;
    public Label dateAndTime;
    public AnchorPane ap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnimationTimer timer = new AnimationTimer() {   //Loading the live clock.
            @Override
            public void handle(long now) {   //Loading the live clock, and setting it to a label.
                dateAndTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss")));
            }
        };
        timer.start();
        Node[] nodes = {image, l1, ucButton, i2, dateAndTime};
        for(Node n : nodes ){
            Animator.getInstance().setJackInTheBox(n);
        }
    }

    public void ucButtonOnAction(ActionEvent actionEvent) {
        Navigator.changePane(ap,"CredentialManager.fxml");
    }
}
