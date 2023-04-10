package com.damian.hms.service.custom;

import com.damian.hms.dto.Room_DTO;

import java.util.ArrayList;

public interface RoomDetailsService extends SuperService<Room_DTO,String> {
    ArrayList<String> getRoomIds();
}
