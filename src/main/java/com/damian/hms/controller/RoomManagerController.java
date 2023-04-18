package com.damian.hms.controller;

import com.damian.hms.dto.Room_DTO;
import com.damian.hms.service.impl.RoomDetailsServiceImpl;
import com.damian.hms.service.util.ServiceFactory;
import com.damian.hms.service.util.ServiceTypes;
import com.damian.hms.util.Animator;
import com.damian.hms.util.GetAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.damian.hms.util.Animator.setJackInTheBox;

public class RoomManagerController implements Initializable {
    public AnchorPane ap;
    public Label l1;
    public JFXComboBox<String> cb;
    public JFXTextField t1;
    public JFXTextField t2;
    public JFXTextField t3;
    public JFXTextField t4;
    public JFXButton update;
    public JFXButton delete;
    public JFXButton add;
    public JFXButton clear;

    private final String[] optionsArray = {"Add a room.", "Update a room.", "Delete a room.","Search rooms."};
    public Label t5;
    public JFXButton search;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> optionsList = FXCollections.observableArrayList();
        Collections.addAll(optionsList, optionsArray);



        cb.setItems(optionsList);
        JFXButton[] buttons = {add, update, delete,search};
        for (JFXButton b : buttons) {
            b.setVisible(false);
        }

        Node[] nodes = {l1, cb, t1, t2, t3, t4,t5, clear};
        for (Node n : nodes) {
            Animator.getInstance().setJackInTheBox(n);
        }


    }

    public void t1OnAction(ActionEvent actionEvent) {
        RoomDetailsServiceImpl service = (RoomDetailsServiceImpl) ServiceFactory.getService(ServiceTypes.RoomDetailsService);
        Optional<Room_DTO> room = service.search(t1.getText());
        if(room.isPresent()) {
            t2.setText(room.get().getRoom_type());
            t3.setText(String.valueOf(room.get().getKey_money()));
            t4.setText(String.valueOf(room.get().getQty()));
        }else{
            GetAlert.getInstance().showAlert("Room not found!" ,Alert.AlertType.ERROR);
        }

    }

    public void cbOnAction(ActionEvent actionEvent) {
        if (cb.getValue().equals(optionsArray[0])) {
            add.setVisible(true);
            Animator.getInstance().setJackInTheBox(add);
        } else {
            add.setVisible(false);
        }
        if (cb.getValue().equals(optionsArray[1])) {
            update.setVisible(true);
            Animator.getInstance().setJackInTheBox(update);
        } else {
            update.setVisible(false);
        }
        if (cb.getValue().equals(optionsArray[2])) {
            delete.setVisible(true);
            Animator.getInstance().setJackInTheBox(delete);
        } else {
            delete.setVisible(false);
        }
        if (cb.getValue().equals(optionsArray[3])) {
            search.setVisible(true);
            Animator.getInstance().setJackInTheBox(search);
        } else {
            search.setVisible(false);
        }

    }

    public void addOnAction(ActionEvent actionEvent) {
        RoomDetailsServiceImpl service = (RoomDetailsServiceImpl) ServiceFactory.getService(ServiceTypes.RoomDetailsService);
        boolean b1 = service.add(new Room_DTO(t1.getText(), t2.getText(), Double.parseDouble(t3.getText()), Integer.parseInt(t4.getText())));
        if (b1) {
            GetAlert.getInstance().showAlert("Room Successfully added!" ,Alert.AlertType.INFORMATION);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        RoomDetailsServiceImpl service = (RoomDetailsServiceImpl) ServiceFactory.getService(ServiceTypes.RoomDetailsService);
        boolean b1 = service.update(new Room_DTO(t1.getText(), t2.getText(), Double.parseDouble(t3.getText()), Integer.parseInt(t4.getText())));
        if (b1) {
            GetAlert.getInstance().showAlert("Room Successfully updated!" ,Alert.AlertType.INFORMATION);
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        RoomDetailsServiceImpl service = (RoomDetailsServiceImpl) ServiceFactory.getService(ServiceTypes.RoomDetailsService);
        boolean b1 = service.delete(t1.getText());
        if (b1) {
            GetAlert.getInstance().showAlert("Room Successfully deleted!" ,Alert.AlertType.INFORMATION);
        }

    }


    public void clearOnAction(ActionEvent actionEvent) {
        TextField[] textFields = {t1, t2, t3, t4};
        for (TextField t : textFields) {
            t.clear();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
        t1OnAction(actionEvent);
    }
}
