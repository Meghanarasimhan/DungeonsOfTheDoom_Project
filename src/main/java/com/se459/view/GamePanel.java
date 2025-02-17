package com.se459.view;

import javax.swing.*;
import java.awt.*;
import com.se459.model.DungeonModel;
import com.se459.model.FloorModel;
import com.se459.model.PlayerModel;
import com.se459.model.RoomModel;

// Panel to draw the room and player on the frame
public class GamePanel extends JPanel {
    private static final int CELL_SIZE = 20; //size of each cell in the room (40x40 pixels)
    private static final int PADDING = 20; //padding around the room (20 pixels)
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
                // Draw the room and player based on the 2D array
                if (i == player.getPositionX() && j == player.getPositionY()) { // if this position is precisely the player's position
                    g.setColor(Color.YELLOW);
                    g.drawString("@", (i * CELL_SIZE) + PADDING, (j * CELL_SIZE) + PADDING); 
                } else { // otherwise, draw the room based on the 2D array
                    g.setColor(Color.GREEN);
                    g.drawString(String.valueOf(room.getCell(i, j)), (i * CELL_SIZE) + PADDING, (j * CELL_SIZE) + PADDING); // adjust i and j by padding to avoid drawing on the border
                }
            }
        }
    }
}
