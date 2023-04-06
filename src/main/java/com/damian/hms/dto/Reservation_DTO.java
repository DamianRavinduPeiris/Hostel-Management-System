package com.damian.hms.dto;

import com.damian.hms.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Reservation_DTO implements SuperDTO{

    private String reservation_Id;
    private Date date;
    private Student student_id;
    private String room_type_id;
    private String payment_status;

}
