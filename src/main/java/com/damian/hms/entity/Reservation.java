package com.damian.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reservation implements SuperEntity {
    @Id
    private String reservation_Id;
    @CreationTimestamp//this annotation will automatically generate the date and time.
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Student student;
    private String room_type_id;
    private String payment_status;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Room room;

}
