package com.se459.model;

import java.util.ArrayList;
import java.util.List;

public class FloorModel {
    private static final int numRooms =1 ;
    private final List<RoomModel> rooms;

    public FloorModel() {

        rooms = new ArrayList<>();
        rooms.add(new RoomModel());
    }

    public int getNumRooms() {
        return numRooms;
    }

    public List<RoomModel> getRooms() {
        return rooms;
    }
}
