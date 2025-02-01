package com.se459;

import com.se459.controller.DungeonController;
import com.se459.model.DungeonModel;
import com.se459.view.DungeonView;

import javax.swing.*;

public class DungeonOfTheDoomApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DungeonModel dungeonModel = new DungeonModel();
            DungeonView dungeonView = new DungeonView();
            DungeonController dungeonController = new DungeonController(dungeonModel, dungeonView);

            dungeonView.setVisible(true);
        });
    }
}
