package com.se459.controller;

import com.se459.model.DungeonModel;
import com.se459.view.DungeonView;
import com.se459.model.PlayerModel;
import java.awt.event.*;

public class DungeonController implements KeyListener, ActionListener {
    private DungeonModel dungeonModel;
    private DungeonView dungeonView;

    public DungeonController(DungeonModel dungeonModel, DungeonView dungeonView) {
        this.dungeonModel = dungeonModel;
        this.dungeonView = dungeonView;
        dungeonView.addKeyListener(this);
        dungeonView.addNameFieldActionListener(this); 
    }

    // Handle key events for player movement (left-arrow, right-arrow, up-arrow, down-arrow)
    @Override
    public void keyPressed(KeyEvent e) {
        PlayerModel player = dungeonModel.getPlayer();
        int newX = player.getPositionX();
        int newY = player.getPositionY();
        boolean isUppercase = Character.isUpperCase(e.getKeyChar());
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT || (keyCode == KeyEvent.VK_H && !isUppercase)) {
            newX--;
        } else if (keyCode == KeyEvent.VK_RIGHT || (keyCode == KeyEvent.VK_L && !isUppercase)) {
            newX++;
        } else if (keyCode == KeyEvent.VK_UP || (keyCode == KeyEvent.VK_K && !isUppercase)) {
            newY--;
        } else if (keyCode == KeyEvent.VK_DOWN || (keyCode == KeyEvent.VK_J && !isUppercase)) {
            newY++;
        } else if (keyCode == KeyEvent.VK_N && !isUppercase) {
            //move down right diagonally
            newX++;
            newY++;
        } else if (keyCode == KeyEvent.VK_B && !isUppercase) {
            //move down left diagonally
            newX--;
            newY++;
        } else if (keyCode == KeyEvent.VK_U && !isUppercase) {
            //move up right diagonally
            newX++;
            newY--;
        } else if (keyCode == KeyEvent.VK_Y && !isUppercase) {
            //move up left diagonally
            newX--;
            newY--;
        }

        // Check if the new position is a wall or not
        if (!dungeonModel.getFloor(0).getRoom(0).isWall(newX, newY)) {
            player.movePlayer(newX, newY);
        }

        //check if player ran into a monster
        if (dungeonModel.getFloor(0).getRoom(0).getMonsterModel() != null &&
                dungeonModel.getFloor(0).getRoom(0).getMonsterModel().getPositionX() == player.getPositionX() &&
                dungeonModel.getFloor(0).getRoom(0).getMonsterModel().getPositionY() == player.getPositionY()
        ) {
            System.out.println("Player ran into monster!");
            dungeonView.showCombatPanel();
        } else {
            dungeonView.repaint(); // repaint the view to update the player's position
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing to do here
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // nothing to do here
    }

    // Handle action event for player entering name
    @Override
    public void actionPerformed(ActionEvent e) {
        String playerName = dungeonView.getPlayerName();
        if (!playerName.isEmpty()) {
            dungeonModel.getPlayer().setPlayerName(playerName);
            dungeonView.showGameView();
        }
    }

}
