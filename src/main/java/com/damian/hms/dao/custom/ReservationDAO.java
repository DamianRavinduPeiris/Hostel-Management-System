package com.damian.hms.dao.custom;

import com.damian.hms.dao.util.SuperDAO;
import com.damian.hms.entity.Reservation;
import com.damian.hms.entity.Student;

import java.util.ArrayList;

public interface ReservationDAO extends SuperDAO<Reservation,String> {
    ArrayList<String> getStudentIds(String roomId);
    ArrayList<Student> nkmStudents();
}
