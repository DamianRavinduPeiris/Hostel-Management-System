package com.damian.hms.service.custom;

import com.damian.hms.dto.Student_DTO;

import java.util.ArrayList;

public interface StudentService extends SuperService<Student_DTO,String>{
    ArrayList<String> getIds();
}
