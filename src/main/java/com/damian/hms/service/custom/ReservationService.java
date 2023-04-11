package com.damian.hms.service.custom;

import com.damian.hms.dto.Reservation_DTO;
import com.damian.hms.dto.Student_DTO;
import com.damian.hms.entity.Student;

import java.util.ArrayList;

public interface ReservationService extends SuperService<Reservation_DTO,String>{
    ArrayList<String>getStudentIds(String room_id);

    String getRoomId(String student_id);


    ArrayList<Student_DTO>nkmStudents();
}
