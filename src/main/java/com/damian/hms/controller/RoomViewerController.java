package com.damian.hms.controller;

import com.damian.hms.convertor.Convertor;
import com.damian.hms.dto.Room_DTO;
import com.damian.hms.service.impl.RoomDetailsServiceImpl;
import com.damian.hms.service.util.ServiceFactory;
import com.damian.hms.service.util.ServiceTypes;
import com.damian.hms.tablemodel.RoomTM;
import com.damian.hms.util.Animator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomViewerController implements Initializable {
    public AnchorPane ap;
    public Label l1;
    public TableView<RoomTM> tableView;
    public TableColumn c1;
    public TableColumn c2;
    public TableColumn c3;
    public TableColumn c4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        c1.setCellValueFactory(new PropertyValueFactory<>("room_id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        c3.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        c4.setCellValueFactory(new PropertyValueFactory<>("qty"));

        RoomDetailsServiceImpl service = ServiceFactory.getService(ServiceTypes.RoomDetailsService);
        ArrayList<Room_DTO> rooms = service.getAll();

        ArrayList<RoomTM> roomTMArrayList = Convertor.toRoomTMArrayList(rooms);

        ObservableList<RoomTM> roomsList = FXCollections.observableArrayList();
        for (RoomTM rt : roomTMArrayList) {
            roomsList.add(rt);
        }
        tableView.setItems(roomsList);


        Node[] nodes = {l1, tableView};
        for (Node n : nodes) {
            Animator.getInstance().setJackInTheBox(n);
        }


    }
}
