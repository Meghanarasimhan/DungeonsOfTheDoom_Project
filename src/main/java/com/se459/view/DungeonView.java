package com.se459.view;

import javax.swing.*;
import java.awt.*;

import com.se459.model.DungeonModel;
import com.se459.model.FloorModel;
import com.se459.model.PlayerModel;
import com.se459.model.RoomModel;

public class DungeonView extends JFrame {

    public DungeonView(DungeonModel dungeonModel) {
        setTitle("Dungeon of the Doom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true); // set the frame focusable, meaning it can receive key events

        // Create a panel to draw the room and player on the frame 
        GamePanel gamePanel = new GamePanel(dungeonModel);
        // Set the preferred size of the panel based on total size of floor by cell size
        gamePanel.setPreferredSize(new Dimension(500, 500));
        add(gamePanel); // add the panel to the frame
        pack(); // pack the frame to fit the panel (meaning the frame will be resized to fit the panel)
        setLocationRelativeTo(null); // center the frame
    }

    // Create a panel to draw the room and player
    private class GamePanel extends JPanel {

        private static final int CELL_SIZE = 20; //size of each cell in the room (40x40 pixels)
        private final FloorModel floorModel;
        private final PlayerModel player;

        public GamePanel(DungeonModel dungeonModel) {
            this.floorModel = dungeonModel.getFloor(0); // get the first floor
            this.player = dungeonModel.getPlayer(); // get the player
        }

        // Draw the room and player on the panel
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            RoomModel room = floorModel.getRoom(0);
            for (int i = 0; i < room.getWidth(); i++) {
                for (int j = 0; j < room.getLength(); j++) {
                    // Draw the room based on the 2D array
                    if (i == player.getPositionX() && j == player.getPositionY()) { // if this position is precisely the player's position
                        g.drawString("@", (i + 1) * CELL_SIZE, (j + 1) * CELL_SIZE);
                    } else if (room.getMonsterModel() != null && (i == room.getMonsterModel().getPositionX() && j == room.getMonsterModel().getPositionY())) {
                        g.drawString(room.getMonsterModel().getScreenChar(), (i + 1) * CELL_SIZE, (j + 1) * CELL_SIZE);
                    } else { // otherwise, draw the room based on the 2D array
                        g.drawString(String.valueOf(room.getCell(i, j)), (i + 1) * CELL_SIZE, (j + 1) * CELL_SIZE); // adjust i and j by 1 to avoid drawing on the border
                    }
                }
            }
        }
    }

}