package com.se459.controller;

import com.se459.model.DungeonModel;
import com.se459.view.DungeonView;
import com.se459.model.PlayerModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DungeonController implements KeyListener {
    private DungeonModel dungeonModel;
    private DungeonView dungeonView;

    public DungeonController(DungeonModel dungeonModel, DungeonView dungeonView) {
        this.dungeonModel = dungeonModel;
        this.dungeonView = dungeonView;
        dungeonView.addKeyListener(this);
    }

    // Handle key events for player movement (left-arrow, right-arrow, up-arrow, down-arrow)
    @Override
    public void keyPressed(KeyEvent e) {
        PlayerModel player = dungeonModel.getPlayer();
        int newX = player.getPositionX();
        int newY = player.getPositionY();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> newX--;
            case KeyEvent.VK_RIGHT -> newX++;
            case KeyEvent.VK_UP -> newY--;
            case KeyEvent.VK_DOWN -> newY++;
            case KeyEvent.VK_A -> { //move down right diagonally
                newX++;
                newY++;
            }
            case KeyEvent.VK_B -> { //move down left diagonally
                newX--;
                newY++;
            }
            case KeyEvent.VK_C -> { //move up right diagonally
                newX++;
                newY--;
            }
            case KeyEvent.VK_D -> { //move up left diagonally
                newX--;
                newY--;
            }
            default -> {
            }
        }
        // Check if the new position is a wall or not
        if (!dungeonModel.getFloor(0).getRoom(0).isWall(newX, newY)) {
            player.movePlayer(newX, newY);
        }
        dungeonView.repaint(); // repaint the view to update the player's position
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing to do here
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // nothing to do here
    }

}
