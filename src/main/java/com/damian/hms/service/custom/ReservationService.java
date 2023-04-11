package com.damian.hms.service.custom;

import com.damian.hms.dto.Reservation_DTO;

import java.util.ArrayList;

public interface ReservationService extends SuperService<Reservation_DTO,String>{
    ArrayList<String>getStudentIds(String room_id);
}
