package com.se459.model;

import java.util.ArrayList;
import java.util.List;

public class DungeonModel {
    private final List<FloorModel> floors;
    private final PlayerModel player;

    public DungeonModel() {
        floors = new ArrayList<>();
        floors.add(new FloorModel());
        // Create Player, using first room on first floor to initialize player's position
        player = new PlayerModel(this.getFloor(0).getRoom(0));
    }

    public int getNumFloors() {
        return floors.size();
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

    public void moveToNextLevel() {
        addFloor();
        FloorModel newFloor = getFloor(getNumFloors() - 1);
        RoomModel newRoom = newFloor.getRoom(0);
        player.randomizeInitialPosition(newRoom);
    }

    public FloorModel getCurrentFloor() {
        return getFloor(getNumFloors() - 1);
    }
}
