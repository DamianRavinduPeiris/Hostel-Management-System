package com.damian.hms.dao.impl;

import com.damian.hms.dao.custom.ReservationDAO;
import com.damian.hms.entity.Reservation;
import com.damian.hms.repository.ReservationRepo;

import java.util.ArrayList;
import java.util.Optional;

public class ReservationDAOIMPL implements ReservationDAO {
    @Override
    public boolean add(Reservation reservation) {
        ReservationRepo reservationRepo = new ReservationRepo();
        return reservationRepo.add(reservation);
    }

    @Override
    public boolean update(Reservation reservation) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Optional<Reservation> search(String s) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Reservation> getAll() {
        return null;
    }
}
