package com.se459.view;

import javax.swing.*;
import java.awt.*;

public class DungeonView extends JFrame {

    // for now, create constants for the room size
    public static final int ROOM_WIDTH = 11;
    public static final int ROOM_HEIGHT = 5;
    public static final int CELL_SIZE = 20;

    // create a 2D array to represent the room
    private char[][] room = new char[ROOM_HEIGHT][ROOM_WIDTH];

    // set player's current position
    private int playerX = 1;
    private int playerY = 1;

    public DungeonView() {
        setTitle("Dungeon of the Doom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ROOM_WIDTH * CELL_SIZE, ROOM_HEIGHT * CELL_SIZE + 40);
        setLocationRelativeTo(null);
        addKeyListener(new KeyHandler(this)); // add key listener to the frame to handle key events
        setFocusable(true); // ensure frame is focusable, meaning it can receive key events 
        initializeRoom();
        add(new DungeonPanel());
    }

// Initialize the room with walls, dots (for different positions), and player
private void initializeRoom() {
    for (int i = 0; i < ROOM_HEIGHT; i++) {
        for (int j = 0; j < ROOM_WIDTH; j++) {
            // if the position is on the border, set it as a wall
            if (i == 0 || i == ROOM_HEIGHT - 1 || j == 0 || j == ROOM_WIDTH - 1) {
                room[i][j] = '#';
            } else {
                room[i][j] = '.'; // otherwise, set it as a dot
            }
        }
    }
}

// Create a panel to draw the room and player
private class DungeonPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < ROOM_HEIGHT; i++) {
            for (int j = 0; j < ROOM_WIDTH; j++) {
                // Draw the room based on the 2D array
                if (i == playerY && j == playerX) { // if the position is the player's position
                    g.drawString("@", j * 20, i * 20);
                } else { // otherwise, draw the room based on the 2D array
                    g.drawString(String.valueOf(room[i][j]), j * 20, i * 20);
                }
            }
        }
    }
}


// Handle player's movement
public void movePlayer(char direction){
    int newX = playerX;
    int newY = playerY;
    // Update the player's position based on the direction of arrow keys (left-arrow, right-arrow, up-arrow, down-arrow)
    switch (direction) {
        case 'L':
            newX = playerX - 1;
            break;
        case 'R':
            newX = playerX + 1;
            break;
        case 'U':
            newY = playerY - 1;
            break;
        case 'D':
            newY = playerY + 1;
            break;
    }
    // Check if the new position is a wall or not
    if (room[newY][newX] != '#') {
        playerX = newX;
        playerY = newY;
    }
    // Repaint the frame to update the player's position
    repaint();

}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        DungeonView view = new DungeonView();
        view.setVisible(true);
    });
}

}