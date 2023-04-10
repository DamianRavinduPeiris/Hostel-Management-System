package com.damian.hms.service.impl;

import com.damian.hms.convertor.Convertor;
import com.damian.hms.dao.impl.RoomDetailsDAOIMPL;
import com.damian.hms.dao.util.DaoFactory;
import com.damian.hms.dao.util.DaoTypes;
import com.damian.hms.dto.Room_DTO;
import com.damian.hms.service.custom.RoomDetailsService;

import java.util.ArrayList;
import java.util.Optional;

public class RoomDetailsServiceImpl implements RoomDetailsService {

    @Override
    public boolean add(Room_DTO roomDto) {
        RoomDetailsDAOIMPL dao = DaoFactory.getDao(DaoTypes.RoomDetailsDAO);
        return dao.add(Convertor.toRoom(roomDto));
    }

    @Override
    public boolean delete(String s) {
        RoomDetailsDAOIMPL dao = (RoomDetailsDAOIMPL) DaoFactory.getDao(DaoTypes.RoomDetailsDAO);
        return  dao.delete(s);
    }

    @Override
    public boolean update(Room_DTO roomDto) {
        RoomDetailsDAOIMPL dao = DaoFactory.getDao(DaoTypes.RoomDetailsDAO);
        return dao.update(Convertor.toRoom(roomDto));
    }

    @Override
    public Optional<Room_DTO> search(String s) {
        RoomDetailsDAOIMPL dao = DaoFactory.getDao(DaoTypes.RoomDetailsDAO);
        if (dao.search(s).isPresent()) {
            return Optional.of(Convertor.toRoom_DTO(dao.search(s).get()));
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<Room_DTO> getAll() {
        RoomDetailsDAOIMPL dao = DaoFactory.getDao(DaoTypes.RoomDetailsDAO);
        return dao.getAll() == null ? null : Convertor.toRoomDtoArrayList(dao.getAll());
    }

    @Override
    public ArrayList<String> getRoomIds() {
        RoomDetailsDAOIMPL dao = DaoFactory.getDao(DaoTypes.RoomDetailsDAO);
        return dao.getRoomIds();
    }
}
