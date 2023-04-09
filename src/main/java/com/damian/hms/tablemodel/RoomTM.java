package com.damian.hms.tablemodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RoomTM {
    private String room_id;
    private String room_type;
    private double key_money;
    private int qty;

}
