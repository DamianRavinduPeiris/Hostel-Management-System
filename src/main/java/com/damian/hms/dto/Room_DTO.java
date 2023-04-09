package com.damian.hms.dto;

import com.damian.hms.entity.Reservation;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@RequiredArgsConstructor


public class Room_DTO implements SuperDTO {
    @NonNull
    private String room_id;
    @NonNull
    private String room_type;
    @NonNull
    private double key_money;
    @NonNull
    private int qty;
    private List<Reservation> reservationList;

}
