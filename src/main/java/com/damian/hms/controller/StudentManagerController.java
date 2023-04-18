package com.damian.hms.controller;

import com.damian.hms.dto.Room_DTO;
import com.damian.hms.dto.Student_DTO;
import com.damian.hms.service.impl.ReservationServiceImpl;
import com.damian.hms.service.impl.RoomDetailsServiceImpl;
import com.damian.hms.service.impl.StudentServiceImpl;
import com.damian.hms.service.util.ServiceFactory;
import com.damian.hms.service.util.ServiceTypes;
import com.damian.hms.util.Animator;
import com.damian.hms.util.GetAlert;
import com.damian.hms.validator.ValidateTypes;
import com.damian.hms.validator.Validator;
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
import javafx.scene.paint.Paint;

import java.net.URL;
import java.sql.Date;
import java.util.Collections;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentManagerController implements Initializable {
    public JFXTextField t2;
    public JFXTextField t3;
    public JFXTextField t4;
    public JFXButton add;
    public JFXButton update;
    public JFXButton delete;
    public JFXButton clear;
    public DatePicker dob;
    public JFXComboBox gb;
    public AnchorPane ap;
    public Label l1;
    public JFXComboBox cb;
    public JFXTextField t1;
    public String[] optionsArray = {"Add a student.", "Update a student.", "Delete a student.","Search a student."};
    public String[] genderArray = {"Male.", "Female."};
    public Label t5;
    public DatePicker dor;
    public Label l3;
    public JFXComboBox idCb;
    public Label l2;
    public JFXComboBox ridCb;
    public JFXComboBox pCb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXButton[] buttons = {add, update, delete};
        for (JFXButton b : buttons) {
            b.setVisible(false);
        }
        ObservableList<Object> optionsList = FXCollections.observableArrayList();
        Collections.addAll(optionsList, optionsArray);
        cb.setItems(optionsList);
        ObservableList<Object> genderList = FXCollections.observableArrayList();
        Collections.addAll(genderList, genderArray);
        gb.setItems(genderList);

        Node[] nodes = {l1, cb, t1, t2, t3, t4, t5, clear};
        for (Node n : nodes) {
            Animator.getInstance().setJackInTheBox(n);
        }


    }

    public void cbOnAction(ActionEvent actionEvent) {
        System.out.println(cb.getValue().toString());
        if (cb.getValue().toString().equals(optionsArray[0])) {
            add.setVisible(true);
            Animator.getInstance().setJackInTheBox(add);
        } else {
            add.setVisible(false);
        }
        if (cb.getValue().toString().equals(optionsArray[1])) {
            update.setVisible(true);
            Animator.getInstance().setJackInTheBox(update);
        } else {
            update.setVisible(false);
        }
        if (cb.getValue().toString().equals(optionsArray[2])) {
            delete.setVisible(true);
            Animator.getInstance().setJackInTheBox(delete);
        } else {
            delete.setVisible(false);
        }
    }

    public void t1OnAction(ActionEvent actionEvent) {
        StudentServiceImpl service = ServiceFactory.getService(ServiceTypes.StudentService);
        Optional<Student_DTO> student = service.search(t1.getText());
        if (student.isPresent()) {
            t2.setText(student.get().getStudent_name());
            t3.setText(student.get().getStudent_address());
            t4.setText(String.valueOf(student.get().getStudent_contact()));
            dob.setValue(student.get().getStudent_dob().toLocalDate());
            gb.setValue(student.get().getGender());

        } else {
            GetAlert.getInstance().showAlert("Student not found !", Alert.AlertType.ERROR);
        }

    }

    public void deleteOnAction(ActionEvent actionEvent) {
        ReservationServiceImpl rs = ServiceFactory.getService(ServiceTypes.ReservationService);
        String roomId = rs.getRoomId(t1.getText());
        if (roomId==null) {
            StudentServiceImpl ss = ServiceFactory.getService(ServiceTypes.StudentService);
            boolean b2 = ss.delete(t1.getText());
            if (b2) {
                GetAlert.getInstance().showAlert("Student Successfully deleted! ", Alert.AlertType.INFORMATION);
            }

        } else {
            RoomDetailsServiceImpl rds = ServiceFactory.getService(ServiceTypes.RoomDetailsService);
            Optional<Room_DTO> room = rds.search(roomId);
            room.get().setQty(room.get().getQty() + 1);
            boolean b1 = rds.update(room.get());
            if (b1) {
                StudentServiceImpl ss = ServiceFactory.getService(ServiceTypes.StudentService);
                boolean b2 = ss.delete(t1.getText());
                if (b2) {
                    GetAlert.getInstance().showAlert("Student Successfully deleted! ", Alert.AlertType.INFORMATION);
                }
            }

        }


    }

    public void clearOnAction(ActionEvent actionEvent) {
        TextField[] textFields = {t1, t2, t3, t4};
        for (TextField t : textFields) {
            t.clear();
        }
        JFXComboBox[] comboBoxes = {cb, gb};
        for (JFXComboBox c : comboBoxes) {
            c.setValue(null);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        if (Validator.check(t4.getText(), ValidateTypes.TELEPHONE)) {
            StudentServiceImpl ss = ServiceFactory.getService(ServiceTypes.StudentService);
            boolean b1 = ss.update(new Student_DTO(t1.getText(), t2.getText(), t3.getText(), Integer.parseInt(t4.getText()), Date.valueOf(dob.getValue()), gb.getValue().toString()));
            if (b1) {
                GetAlert.getInstance().showAlert("Student Successfully updated! ", Alert.AlertType.INFORMATION);
            }
        } else {
            t4.setFocusColor(Paint.valueOf("red"));
            Animator.getInstance().setShake(t4);
            GetAlert.getInstance().showAlert("Invalid telephone number !", Alert.AlertType.ERROR);
        }
    }

    public void addOnAction(ActionEvent actionEvent) {
        if (Validator.check(t4.getText(), ValidateTypes.TELEPHONE)) {
            StudentServiceImpl ss = ServiceFactory.getService(ServiceTypes.StudentService);
            boolean b1 = ss.add(new Student_DTO(t1.getText(), t2.getText(), t3.getText(), Integer.parseInt(t4.getText()), Date.valueOf(dob.getValue()), gb.getValue().toString()));
            if (b1) {
                GetAlert.getInstance().showAlert("Student Successfully added! ", Alert.AlertType.INFORMATION);
            }
        } else {
            t4.setFocusColor(Paint.valueOf("red"));
            Animator.getInstance().setShake(t4);
            GetAlert.getInstance().showAlert("Invalid telephone number !", Alert.AlertType.ERROR);
        }


    }


}
