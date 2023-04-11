package com.damian.hms.service.impl;

import com.damian.hms.convertor.Convertor;
import com.damian.hms.dao.impl.ReservationDAOIMPL;
import com.damian.hms.dao.util.DaoFactory;
import com.damian.hms.dao.util.DaoTypes;
import com.damian.hms.dto.Reservation_DTO;
import com.damian.hms.dto.Student_DTO;
import com.damian.hms.entity.Student;
import com.damian.hms.service.custom.ReservationService;

import java.util.ArrayList;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {
    @Override
    public boolean add(Reservation_DTO reservationDto) {
        ReservationDAOIMPL dao = (ReservationDAOIMPL) DaoFactory.getDao(DaoTypes.ReservationDAO);
        return dao.add(Convertor.toReservation(reservationDto));
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(Reservation_DTO reservationDto) {
        ReservationDAOIMPL dao = (ReservationDAOIMPL) DaoFactory.getDao(DaoTypes.ReservationDAO);
        return dao.update(Convertor.toReservation(reservationDto));
    }

    @Override
    public Optional<Reservation_DTO> search(String s) {
        ReservationDAOIMPL dao = (ReservationDAOIMPL) DaoFactory.getDao(DaoTypes.ReservationDAO);
        if(dao.search(s).isPresent()){
            return Optional.of(Convertor.toReservationDto(dao.search(s).get()));
        }

        return Optional.empty();
    }

    @Override
    public ArrayList<Reservation_DTO> getAll() {
        return null;
    }

    @Override
    public ArrayList<String> getStudentIds(String room_id) {
        ReservationDAOIMPL dao = (ReservationDAOIMPL) DaoFactory.getDao(DaoTypes.ReservationDAO);
        return dao.getStudentIds(room_id);
    }

    @Override
    public String getRoomId(String student_id) {
        ReservationDAOIMPL dao = (ReservationDAOIMPL) DaoFactory.getDao(DaoTypes.ReservationDAO);
        return dao.getRoomId(student_id);
    }

    @Override
    public ArrayList<Student_DTO> nkmStudents() {
        ReservationDAOIMPL rs = (ReservationDAOIMPL) DaoFactory.getDao(DaoTypes.ReservationDAO);
        return Convertor.toStudentDtoArrayList(rs.nkmStudents());
    }
}
