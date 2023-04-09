package com.damian.hms.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Entity
@RequiredArgsConstructor

public class Room implements SuperEntity{
    @Id
    @NonNull
    private String room_id;
    @NonNull
    private String room_type;
    @NonNull
    private double key_money;
    @NonNull
    private int qty;
    @OneToMany(targetEntity = Reservation.class,mappedBy = "room_id")
    private List<Reservation> reservationList;

}
