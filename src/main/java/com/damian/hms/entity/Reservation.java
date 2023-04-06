package com.damian.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
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
    @ManyToOne
    private Student student_id;
    private String room_type_id;
    private String payment_status;
    @ManyToOne
    private Room room_id;

}
