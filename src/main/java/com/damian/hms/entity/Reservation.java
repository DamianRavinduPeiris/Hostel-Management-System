package com.damian.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reservation implements SuperEntity {
    @Id
    private String reservation_Id;
    private Date date;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    private String room_type_id;
    private String payment_status;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;



}
