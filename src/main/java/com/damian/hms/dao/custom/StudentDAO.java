package com.damian.hms.dao.custom;

import com.damian.hms.dao.util.SuperDAO;
import com.damian.hms.entity.Student;

import java.util.ArrayList;

public interface StudentDAO extends SuperDAO<Student,String>{
    ArrayList<String> getIds();
}
