package com.damian.hms.service.impl;

import com.damian.hms.convertor.Convertor;
import com.damian.hms.dao.impl.StudentDAOIMPL;
import com.damian.hms.dao.util.DaoFactory;
import com.damian.hms.dao.util.DaoTypes;
import com.damian.hms.dto.Student_DTO;
import com.damian.hms.entity.Student;
import com.damian.hms.service.custom.StudentService;

import java.util.ArrayList;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Override
    public boolean add(Student_DTO studentDto) {
        StudentDAOIMPL dao = (StudentDAOIMPL) DaoFactory.getDao(DaoTypes.StudentDAO);
        return dao.add(Convertor.toStudent(studentDto));
    }

    @Override
    public boolean delete(String s) {
        StudentDAOIMPL dao = (StudentDAOIMPL) DaoFactory.getDao(DaoTypes.StudentDAO);
        return dao.delete(s);
    }

    @Override
    public boolean update(Student_DTO studentDto) {
        StudentDAOIMPL dao = (StudentDAOIMPL) DaoFactory.getDao(DaoTypes.StudentDAO);
        return dao.update(Convertor.toStudent(studentDto));
    }

    @Override
    public Optional<Student_DTO> search(String s) {
        StudentDAOIMPL dao = (StudentDAOIMPL) DaoFactory.getDao(DaoTypes.StudentDAO);
        if(dao.search(s).isPresent()){
            return Optional.of(Convertor.toStudent_DTO(dao.search(s).get()));
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<Student_DTO> getAll() {
        StudentDAOIMPL dao = (StudentDAOIMPL) DaoFactory.getDao(DaoTypes.StudentDAO);
        return Convertor.toStudentDtoArrayList(dao.getAll());

    }

    @Override
    public ArrayList<String> getIds() {
        StudentDAOIMPL dao = (StudentDAOIMPL) DaoFactory.getDao(DaoTypes.StudentDAO);
        return dao.getIds();
    }
}
