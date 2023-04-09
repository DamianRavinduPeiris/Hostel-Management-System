package com.damian.hms.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Navigator {
    public static void navigate(Stage stage, NavigateTypes navigateType) {
        if (Objects.requireNonNull(navigateType) == NavigateTypes.DASHBOARD) {
            changeUI(stage, "Dashboard.fxml", "Admin Dashboard.");
        } else {
            GetAlert.getInstance().showAlert("Not implemented yet!", Alert.AlertType.ERROR);
        }

    }

    public static void changePane(AnchorPane ap, String location) {
        ap.getChildren().clear();
        try {
            ap.getChildren().add(FXMLLoader.load(Navigator.class.getResource("/view/" + location)));
        } catch (IOException e) {

            GetAlert.getInstance().showAlert("Error while navigating! : " + e.getLocalizedMessage(), Alert.AlertType.ERROR);
        }
        Animator.getInstance().setJackInTheBox(ap);


    }


    public static void changeUI(Stage stage, String location, String title) {
        stage.close();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Navigator.class.getResource("/view/" + location))));
            stage.setTitle(title);
            stage.setMaximized(true);
        } catch (IOException e) {
            GetAlert.getInstance().showAlert("Error while navigating! : " + e.getLocalizedMessage(), Alert.AlertType.ERROR);

        }
        stage.show();

    }
}
