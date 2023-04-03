package com.damian.hms;

import animatefx.animation.LightSpeedIn;
import com.damian.hms.util.PropertyInjector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = AppInitializer.class.getResource("/view/HomeScreen.fxml");
        primaryStage.setScene(new Scene(FXMLLoader.load(resource)));
        primaryStage.setTitle("D24 - Hostel.");
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("https://bit.ly/3ntH6G6"));
        primaryStage.show();

    }

}