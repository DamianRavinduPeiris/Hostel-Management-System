package com.damian.hms.controller;

import com.damian.hms.util.Animator;
import com.damian.hms.util.NavigateTypes;
import com.damian.hms.util.Navigator;
import com.jfoenix.controls.JFXButton;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public JFXButton ucButton;

    public Label dateAndTime;
    public AnchorPane ap;

    public JFXButton crButton;
    public JFXButton mrButton;
    public JFXButton mResButton;
    public JFXButton msStudents;
    public ImageView i1;

    public JFXButton homeButton;

    public HBox h1;
    public VBox v1;
    public VBox v2;
    public ImageView i3;
    public Label l3;
    public JFXButton swhrr;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnimationTimer timer = new AnimationTimer() {   //Loading the live clock.
            @Override
            public void handle(long now) {   //Loading the live clock, and setting it to a label.
                dateAndTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss")));
            }
        };
        timer.start();
        Node[] nodes = { ucButton,  dateAndTime,  crButton, mrButton, mResButton, msStudents, i1,homeButton,  h1, v1, v2,i3,l3,swhrr};
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
        Navigator.changePane(ap,"ReservationManager.fxml");
    }

    public void msButtonOnAction(ActionEvent actionEvent) {
        Navigator.changePane(ap,"StudentManager.fxml");
    }

    public void homeButtonOnAction(ActionEvent actionEvent) {
        Navigator.navigate((Stage)h1.getScene().getWindow(), NavigateTypes.HOME);
    }

    public void swrrButtonOnAction(ActionEvent actionEvent) {
        Navigator.changePane(ap,"StudentDetails.fxml");
    }
}
