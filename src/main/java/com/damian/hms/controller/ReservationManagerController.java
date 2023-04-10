package com.damian.hms.controller;

import com.damian.hms.convertor.Convertor;
import com.damian.hms.dto.Reservation_DTO;
import com.damian.hms.dto.Room_DTO;
import com.damian.hms.dto.Student_DTO;
import com.damian.hms.service.impl.ReservationServiceImpl;
import com.damian.hms.service.impl.RoomDetailsServiceImpl;
import com.damian.hms.service.impl.StudentServiceImpl;
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
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReservationManagerController implements Initializable {
    public AnchorPane ap;
    public Label l1;
    public JFXTextField t1;
    public JFXButton add;
    public JFXButton clear;
    public DatePicker dor;
    public Label l3;
    public JFXComboBox idCb;
    public Label l2;
    public JFXComboBox ridCb;
    public JFXComboBox pCb;
    public String[] paymentStatus = {"Paid.", "Not Paid."};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[]{l1, t1, add, clear, dor, l3, idCb, l2, ridCb, pCb};
        for (Node node : nodes) {
            Animator.getInstance().setJackInTheBox(node);
        }
        ObservableList<String> pStatus = FXCollections.observableArrayList(paymentStatus);
        pCb.setItems(pStatus);

        StudentServiceImpl ss = ServiceFactory.getService(ServiceTypes.StudentService);
        ArrayList<String> ids = ss.getIds();
        FXCollections.observableArrayList(ids);
        idCb.setItems(FXCollections.observableArrayList(ids));


        RoomDetailsServiceImpl rs = ServiceFactory.getService(ServiceTypes.RoomDetailsService);
        ArrayList<String> roomIds = rs.getRoomIds();
        FXCollections.observableArrayList(roomIds);
        ridCb.setItems(FXCollections.observableArrayList(roomIds));


    }


    public void t1OnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) {
        StudentServiceImpl ss = (StudentServiceImpl) ServiceFactory.getService(ServiceTypes.StudentService);
        Optional<Student_DTO> student = ss.search(idCb.getValue().toString());

        RoomDetailsServiceImpl rs = (RoomDetailsServiceImpl) ServiceFactory.getService(ServiceTypes.RoomDetailsService);
        Optional<Room_DTO> room = rs.search(ridCb.getValue().toString());


        ReservationServiceImpl res = (ReservationServiceImpl) ServiceFactory.getService(ServiceTypes.ReservationService);
        boolean b1 = res.add(new Reservation_DTO(t1.getText(), Date.valueOf(dor.getValue()), Convertor.toStudent(student.get()), ridCb.getValue().toString(), pCb.getValue().toString(), Convertor.toRoom(room.get())));
        if(b1){
            RoomDetailsServiceImpl roomDetailsService = (RoomDetailsServiceImpl) ServiceFactory.getService(ServiceTypes.RoomDetailsService);
            Optional<Room_DTO> room1 = roomDetailsService.search(ridCb.getValue().toString());
            System.out.println(ridCb.getValue().toString());
            System.out.println(room1.get().getQty());
            room1.get().setQty(room1.get().getQty() - 1);
            boolean b2 = roomDetailsService.update(room1.get());
            if(b2){
                GetAlert.getInstance().showAlert("Reservation successfully added!", Alert.AlertType.INFORMATION);
            }


        }


    }

    public void clearOnAction(ActionEvent actionEvent) {
        t1.clear();
        dor.getEditor().clear();
        idCb.getSelectionModel().clearSelection();
        ridCb.getSelectionModel().clearSelection();
        pCb.getSelectionModel().clearSelection();
    }


}
