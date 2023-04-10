package com.damian.hms.dao.impl;

import com.damian.hms.dao.custom.StudentDAO;

import com.damian.hms.entity.Student;
import com.damian.hms.repository.StudentRepo;

import java.util.ArrayList;
import java.util.Optional;

public class StudentDAOIMPL implements StudentDAO {
    @Override
    public boolean add(Student student) {
        StudentRepo sr = new StudentRepo();
        return sr.add(student);
    }

    @Override
    public boolean update(Student student) {
        StudentRepo sr = new StudentRepo();
        return sr.update(student);
    }

    @Override
    public boolean delete(String s) {
        StudentRepo sr = new StudentRepo();
        return sr.delete(s);
    }

    @Override
    public Optional<Student> search(String s) {
        StudentRepo sr = new StudentRepo();
        return sr.search(s);
    }

    @Override
    public ArrayList<Student> getAll() {
       StudentRepo sr = new StudentRepo();
         return sr.getAll();
    }

    @Override
    public ArrayList<String> getIds() {
        StudentRepo sr = new StudentRepo();
        return sr.getStudentIds();
    }
}
