package com.damian.hms.dto;

import com.damian.hms.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Student_DTO implements SuperDTO{

    private String student_id;
    private String student_name;
    private String student_address;
    private int student_contact;
    private Date student_dob;
    private String gender;
}
