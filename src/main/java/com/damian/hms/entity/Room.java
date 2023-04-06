package com.damian.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Room implements SuperEntity{
    @Id
    private String room_id;
    private String room_type;
    private double key_money;
    private int qty;
    @OneToMany(targetEntity = Reservation.class,mappedBy = "room_id")
    private List<Reservation> reservationList;

}
