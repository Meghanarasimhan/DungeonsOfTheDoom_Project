package com.se459.controller;

import com.se459.model.DungeonModel;
import com.se459.view.DungeonView;

public class DungeonController {
    private DungeonModel dungeonModel;
    private DungeonView dungeonView;

    public DungeonController(DungeonModel dungeonModel, DungeonView dungeonView) {
        this.dungeonModel = dungeonModel;
        this.dungeonView = dungeonView;
    }
}
