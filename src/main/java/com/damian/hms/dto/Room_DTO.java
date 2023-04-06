package com.damian.hms.dto;

import com.damian.hms.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class Room_DTO implements SuperDTO {
    private String room_id;
    private String room_type;
    private double key_money;
    private int qty;
    private List<Reservation> reservationList;

}
