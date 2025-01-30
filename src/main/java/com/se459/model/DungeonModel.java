package com.se459.model;

import java.util.ArrayList;
import java.util.List;

public class DungeonModel {
    private final int numFloors;
    private final List<FloorModel> floors;

    public DungeonModel() {
        numFloors = 1;
        floors = new ArrayList<>();
        floors.add(new FloorModel());
    }

    public int getNumFloors() {
        return numFloors;
    }

    public List<FloorModel> getFloors() {
        return floors;
    }
}
