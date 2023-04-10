package com.damian.hms.convertor;

import com.damian.hms.dto.LoginDetails_DTO;
import com.damian.hms.dto.Reservation_DTO;
import com.damian.hms.dto.Room_DTO;
import com.damian.hms.dto.Student_DTO;
import com.damian.hms.entity.LoginDetails;
import com.damian.hms.entity.Reservation;
import com.damian.hms.entity.Room;
import com.damian.hms.entity.Student;
import com.damian.hms.tablemodel.RoomTM;

import java.util.ArrayList;

public class Convertor {
    public static LoginDetails_DTO convertLoginDetailsToLoginDetails_DTO(LoginDetails loginDetails) {
        return new LoginDetails_DTO(loginDetails.getUser_ID(), loginDetails.getUserName(), loginDetails.getPassword());
    }

    public static LoginDetails convertLoginDetails_DTOToLoginDetails(LoginDetails_DTO loginDetails_dto) {
        return new LoginDetails(loginDetails_dto.getUser_ID(), loginDetails_dto.getUserName(), loginDetails_dto.getPassword());
    }

    public static Room toRoom(Room_DTO room_dto) {
        return new Room(room_dto.getRoom_id(), room_dto.getRoom_type(), room_dto.getKey_money(), room_dto.getQty(), room_dto.getReservationList());
    }

    public static Room_DTO toRoom_DTO(Room room) {
        return new Room_DTO(room.getRoom_id(), room.getRoom_type(), room.getKey_money(), room.getQty(), room.getReservationList());
    }

    public static ArrayList<Room_DTO> toRoomDtoArrayList(ArrayList<Room> roomArrayList) {
        ArrayList<Room_DTO> room_dtoArrayList = new ArrayList<>();
        for (Room room : roomArrayList) {
            room_dtoArrayList.add(toRoom_DTO(room));
        }
        return room_dtoArrayList;
    }

    public static ArrayList<RoomTM> toRoomTMArrayList(ArrayList<Room_DTO> room_dtoArrayList) {
        ArrayList<RoomTM> roomTMArrayList = new ArrayList<>();
        for (Room_DTO room_dto : room_dtoArrayList) {
            roomTMArrayList.add(new RoomTM(room_dto.getRoom_id(), room_dto.getRoom_type(), room_dto.getKey_money(), room_dto.getQty()));
        }
        return roomTMArrayList;
    }

    public static Student toStudent(Student_DTO student_dto) {
        return new Student(student_dto.getStudent_id(), student_dto.getStudent_name(), student_dto.getStudent_address(), student_dto.getStudent_contact(), student_dto.getStudent_dob(), student_dto.getGender());
    }

    public static Student_DTO toStudent_DTO(Student student) {
        return new Student_DTO(student.getStudent_id(), student.getStudent_name(), student.getStudent_address(), student.getStudent_contact(), student.getStudent_dob(), student.getGender());
    }

    public static ArrayList<Student_DTO> toStudentDtoArrayList(ArrayList<Student> studentArrayList) {
        ArrayList<Student_DTO> student_dtoArrayList = new ArrayList<>();
        for (Student student : studentArrayList) {
            student_dtoArrayList.add(toStudent_DTO(student));
        }
        return student_dtoArrayList;
    }

    public static Reservation toReservation(Reservation_DTO reservation_dto) {
        return new Reservation(reservation_dto.getReservation_Id(), reservation_dto.getDate(), reservation_dto.getStudent_id(), reservation_dto.getRoom_type_id(), reservation_dto.getPayment_status(), reservation_dto.getRoom_id());
    }

    public static Reservation_DTO toReservation_DTO(Reservation reservation) {
        return new Reservation_DTO(reservation.getReservation_Id(), reservation.getDate(), reservation.getStudent(), reservation.getRoom_type_id(), reservation.getPayment_status(), reservation.getRoom());
    }


}
