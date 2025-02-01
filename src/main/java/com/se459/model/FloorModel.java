package com.se459.model;

import java.util.ArrayList;
import java.util.List;

public class FloorModel {
    private final int numRooms;
    private final List<RoomModel> rooms;

    public FloorModel() {
        numRooms = 1;
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
