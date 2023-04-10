package com.damian.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reservation implements SuperEntity {
    @Id
    private String reservation_Id;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Student student_id;
    private String room_type_id;
    private String payment_status;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Room room_id;

}
