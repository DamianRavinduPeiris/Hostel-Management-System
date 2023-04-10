package com.damian.hms.service.impl;

import com.damian.hms.convertor.Convertor;
import com.damian.hms.dao.impl.ReservationDAOIMPL;
import com.damian.hms.dao.util.DaoFactory;
import com.damian.hms.dao.util.DaoTypes;
import com.damian.hms.dto.Reservation_DTO;
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
        return false;
    }

    @Override
    public Optional<Reservation_DTO> search(String s) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Reservation_DTO> getAll() {
        return null;
    }
}
