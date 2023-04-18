package com.damian.hms.controller;

import com.damian.hms.convertor.Convertor;
import com.damian.hms.dto.Student_DTO;
import com.damian.hms.service.impl.ReservationServiceImpl;
import com.damian.hms.service.impl.RoomDetailsServiceImpl;
import com.damian.hms.service.impl.StudentServiceImpl;
import com.damian.hms.service.util.ServiceFactory;
import com.damian.hms.service.util.ServiceTypes;
import com.damian.hms.tablemodel.StudentTM;
import com.damian.hms.util.Animator;
import com.damian.hms.util.GetAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentDetailsController implements Initializable {
    public AnchorPane ap;
    public Label l1;
    public TableView<StudentTM> tableView;
    public TableColumn c1;
    public TableColumn c2;
    public TableColumn c3;
    public TableColumn c4;
    public TableColumn c5;
    public TableColumn c6;
    public JFXComboBox ridCb;
    public Label l2;
    public JFXButton km;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c1.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        c3.setCellValueFactory(new PropertyValueFactory<>("student_address"));
        c4.setCellValueFactory(new PropertyValueFactory<>("student_contact"));
        c5.setCellValueFactory(new PropertyValueFactory<>("student_dob"));
        c6.setCellValueFactory(new PropertyValueFactory<>("gender"));

        RoomDetailsServiceImpl rs = ServiceFactory.getService(ServiceTypes.RoomDetailsService);
        ArrayList<String> roomIds = rs.getRoomIds();
        ObservableList<String> rIds = FXCollections.observableArrayList(roomIds);
        ridCb.setItems(rIds);

        Node[] nodes = {l1, tableView, l2, ridCb, km};
        for (Node n : nodes) {
            Animator.getInstance().setJackInTheBox(n);
        }

    }

    public void ridCbOnAction(ActionEvent actionEvent) {
        tableView.getItems().clear();
        ReservationServiceImpl rs = ServiceFactory.getService(ServiceTypes.ReservationService);
        ArrayList<String> studentIds = rs.getStudentIds(ridCb.getValue().toString());
        if (studentIds.isEmpty()) {
            tableView.getItems().clear();
            GetAlert.getInstance().showAlert("No Students booked this room!", Alert.AlertType.INFORMATION);
        }
        ObservableList<StudentTM> students = FXCollections.observableArrayList();

        StudentServiceImpl ss = ServiceFactory.getService(ServiceTypes.StudentService);
        for (String s : studentIds) {
            Optional<Student_DTO> sId = ss.search(s);
            if (sId.isPresent()) {
                students.add(Convertor.toStudentTM(sId.get()));
                tableView.setItems(students);
            }
        }

    }


    public void kmOnAction(ActionEvent actionEvent) {
        tableView.getItems().clear();
        ReservationServiceImpl rs = ServiceFactory.getService(ServiceTypes.ReservationService);
        ArrayList<Student_DTO> students = rs.nkmStudents();
        ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();
        if(students.isEmpty()){
            GetAlert.getInstance().showAlert("No students yet!", Alert.AlertType.INFORMATION);
        }else{
            for (Student_DTO sd : students) {
                studentTMS.add(Convertor.toStudentTM(sd));
            }
            tableView.setItems(studentTMS);


        }



    }
}
