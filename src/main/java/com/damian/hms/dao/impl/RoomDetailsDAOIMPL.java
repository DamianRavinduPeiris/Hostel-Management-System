package com.damian.hms.dao.impl;

import com.damian.hms.dao.custom.RoomDetailsDAO;
import com.damian.hms.entity.Room;
import com.damian.hms.repository.RoomRepo;

import java.util.ArrayList;
import java.util.Optional;

public class RoomDetailsDAOIMPL implements RoomDetailsDAO {
    @Override
    public boolean add(Room room) {
        RoomRepo r = new RoomRepo();
        return r.add(room);
    }

    @Override
    public boolean update(Room room) {
        RoomRepo r = new RoomRepo();
        return r.update(room);
    }

    @Override
    public boolean delete(String id) {
        RoomRepo r = new RoomRepo();
        return r.delete(id);
    }

    @Override
    public Optional<Room> search(String s) {
        RoomRepo r = new RoomRepo();
        return Optional.ofNullable(r.search(s));
    }

    @Override
    public ArrayList<Room> getAll() {
        RoomRepo r = new RoomRepo();
        return r.getAll();
    }

    @Override
    public ArrayList<String> getRoomIds() {
        RoomRepo r = new RoomRepo();
        return r.getRoomIds();
    }
}
