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
    public ImageView i3;
    public ImageView i4;
    public ImageView i5;
    public ImageView i6;
    public JFXButton crButton;
    public JFXButton mrButton;
    public JFXButton mResButton;
    public JFXButton msStudents;
    public Label l2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnimationTimer timer = new AnimationTimer() {   //Loading the live clock.
            @Override
            public void handle(long now) {   //Loading the live clock, and setting it to a label.
                dateAndTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss")));
            }
        };
        timer.start();
        Node[] nodes = {image, l1, ucButton, i2, dateAndTime, i3, i4, i5, i6, crButton, mrButton, mResButton, msStudents, l2};
        for (Node n : nodes) {
            Animator.getInstance().setJackInTheBox(n);
        }
    }

    public void ucButtonOnAction(ActionEvent actionEvent) {
        Navigator.changePane(ap, "CredentialManager.fxml");
    }

    public void crButtonOnAction(ActionEvent actionEvent) {
        Navigator.changePane(ap,"RoomViewer.fxml");
    }

    public void mrButtonOnAction(ActionEvent actionEvent) {
        Navigator.changePane(ap,"RoomManager.fxml");
    }

    public void mResButtonOnAction(ActionEvent actionEvent) {
    }

    public void msButtonOnAction(ActionEvent actionEvent) {
    }
}
