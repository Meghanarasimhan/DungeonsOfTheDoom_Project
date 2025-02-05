package com.se459.model;

import java.util.ArrayList;
import java.util.List;

public class DungeonModel {
    private final int numFloors;
    private final List<FloorModel> floors;
    private final PlayerModel player;

    public DungeonModel() {
        numFloors = 1;
        floors = new ArrayList<>();
        floors.add(new FloorModel());
        player = new PlayerModel(1, 1);
    }

    public int getNumFloors() {
        return numFloors;
    }

    public List<FloorModel> getFloors() {
        return floors;
    }

    public FloorModel getFloor(int index) {
        return floors.get(index);
    }

    public void addFloor() {
        floors.add(new FloorModel());
    }

    public PlayerModel getPlayer() {
        return player;
    }
}
