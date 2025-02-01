package com.se459.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.se459.view.DungeonView;


public class KeyHandler implements KeyListener {
    private DungeonView dungeonView;
    public KeyHandler(DungeonView dungeonView) {
        this.dungeonView = dungeonView;
    }

    // Handle key events for player movement (left-arrow, right-arrow, up-arrow, down-arrow)
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                dungeonView.movePlayer('L');
                break;
            case KeyEvent.VK_RIGHT:
                dungeonView.movePlayer('R');
                break;
            case KeyEvent.VK_UP:
                dungeonView.movePlayer('U');
                break;
            case KeyEvent.VK_DOWN:
                dungeonView.movePlayer('D');
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
