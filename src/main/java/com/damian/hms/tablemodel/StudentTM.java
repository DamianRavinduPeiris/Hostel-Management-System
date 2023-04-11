package com.damian.hms.tablemodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentTM {
    private String student_id;
    private String student_name;
    private String student_address;
    private int student_contact;
    private Date student_dob;
    private String gender;

}
