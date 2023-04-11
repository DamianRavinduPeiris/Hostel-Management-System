package com.damian.hms.dao.custom;

import com.damian.hms.dao.util.SuperDAO;
import com.damian.hms.entity.Reservation;

import java.util.ArrayList;

public interface ReservationDAO extends SuperDAO<Reservation,String> {
    ArrayList<String> getStudentIds(String roomId);
}
