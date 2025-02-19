package com.se459;

import com.se459.controller.DungeonController;
import com.se459.model.DungeonModel;
import com.se459.view.DungeonView;

import javax.swing.*;

public class DungeonOfTheDoomApp {
    private final static DungeonModel dungeonModel = new DungeonModel();
    private final static DungeonView dungeonView = new DungeonView(dungeonModel);
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DungeonController dungeonController = new DungeonController(dungeonModel, dungeonView);
            dungeonView.setVisible(true);
        });
    }

    public static void shutdown() {
        dungeonView.dispose();
    }
}
