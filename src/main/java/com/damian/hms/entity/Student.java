package com.damian.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Student implements SuperEntity{
    @Id
    private String student_id;
    private String student_name;
    private String student_address;
    private int student_contact;
    private Date student_dob;
    private String gender;
    @OneToMany(targetEntity = Reservation.class,mappedBy = "student_id")
    private List<Reservation> reservationList;
}
