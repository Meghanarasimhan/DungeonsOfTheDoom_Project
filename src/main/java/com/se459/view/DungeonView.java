package com.se459.view;

import javax.swing.*;
import java.awt.*;
import com.se459.model.DungeonModel;
import com.se459.model.PlayerModel;

public class DungeonView extends JFrame {

    private JLabel messageLabel;
    private JLabel statsLabel;

    public DungeonView(DungeonModel dungeonModel) {
        setTitle("Dungeon of the Doom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true); // Set the frame focusable, meaning it can receive key events
        setLayout(new BorderLayout()); // Set the layout of the frame to BorderLayout

        // Create a panel to display messages
        JPanel messagePanel = new JPanel(); 
        messagePanel.setPreferredSize(new Dimension(700, 50)); 
        messagePanel.setBackground(Color.BLACK); 
        messageLabel = new JLabel("Welcome to the Dungeon of the Doom!"); // Create a label to display messages
        messageLabel.setForeground(Color.WHITE); 
        messageLabel.setFont(new Font("Monospaced", Font.BOLD, 16)); 
        messagePanel.add(messageLabel); // Add the label to the panel
        add(messagePanel, BorderLayout.NORTH); // Add the message panel to the frame at the top
        
        // Create a panel to draw the room and player on the frame 
        GamePanel gamePanel = new GamePanel(dungeonModel);
        // Set the preferred size of the panel based on total size of floor by cell size
        gamePanel.setPreferredSize(new Dimension(700,400));
        gamePanel.setBackground(Color.BLACK); 
        add(gamePanel, BorderLayout.CENTER); // Add the panel to the frame
        
        // Create a panel to display player stats
        JPanel statsPanel = new JPanel();
        statsPanel.setPreferredSize(new Dimension(700, 50)); 
        statsPanel.setBackground(Color.BLACK); 
        statsLabel = new JLabel(dungeonModel.getPlayer().displayStats()); 
        statsLabel.setForeground(Color.YELLOW); 
        statsLabel.setFont(new Font("Monospaced", Font.CENTER_BASELINE, 16)); 
        statsPanel.add(statsLabel); // Add the label to the panel
        add(statsPanel, BorderLayout.SOUTH); // Add the stats panel to the frame at the bottom

        pack(); // Pack the frame to fit the panel (meaning the frame will be resized to fit the panel)
        setLocationRelativeTo(null); // Center the frame
    }

    // Update the message label with the given message
    public void updateMessage(String message) {
        messageLabel.setText(message);
        repaint(); // Repaint the frame to display the updated message
    }

    // Update the stats label with the player's health and attack
    public void updateStats(PlayerModel playerModel) {
        statsLabel.setText(playerModel.displayStats());
        repaint(); // Repaint the frame to display the updated stats
    }

}