package com.damian.hms.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Entity
@RequiredArgsConstructor

public class Student implements SuperEntity{
    @Id
    @NonNull
    private String student_id;
    @NonNull
    private String student_name;
    @NonNull
    private String student_address;
    @NonNull
    private int student_contact;
    @NonNull
    private Date student_dob;
    @NonNull
    private String gender;
    @OneToMany(targetEntity = Reservation.class,mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reservation> reservationList;
}
