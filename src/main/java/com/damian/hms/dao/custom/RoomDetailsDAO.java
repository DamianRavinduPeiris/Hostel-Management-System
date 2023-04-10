package com.damian.hms.dao.custom;

import com.damian.hms.dao.util.SuperDAO;
import com.damian.hms.entity.Room;

import java.util.ArrayList;

public interface RoomDetailsDAO extends SuperDAO<Room,String> {
    ArrayList<String> getRoomIds();
}
