package com.se459.view;

import javax.swing.*;
import java.awt.*;

import com.se459.model.DungeonModel;
import com.se459.model.PlayerModel;
import java.awt.event.ActionListener;

public class DungeonView extends JFrame {

    private JLabel messageLabel;
    private JLabel statsLabel;
    private JPanel mainPanel; // main game panel
    private JTextField nameField; // text field to enter player name
    private DungeonModel dungeonModel;
    private GamePanel gamePanel;

    public DungeonView(DungeonModel dungeonModel) {
        this.dungeonModel = dungeonModel;
        setTitle("Dungeons of Doom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true); // Set the frame focusable, meaning it can receive key events
        mainPanel = new JPanel(new BorderLayout()); // Set the layout of the frame to BorderLayout

        // Create initial view to enter player name
        // First, create panel to display title of game
        JPanel initialPanel = new JPanel(new BorderLayout());
        initialPanel.setPreferredSize(new Dimension(700, 400));
        initialPanel.setBackground(Color.BLACK);
        JLabel titleLabel = new JLabel("ROGUE: The Adventure Game", SwingConstants.CENTER); // Create label to display title of the game (SwingConstants.CENTER centers the text)
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
        titleLabel.setForeground(Color.GREEN); // Set the color of the text to white
        initialPanel.add(titleLabel, BorderLayout.CENTER); // Add the title label to the panel at the top

        // Create panel to enter player name
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.BLACK);
        JLabel nameLabel = new JLabel("Rogue's Name? "); // Create label to prompt user to enter name
        nameLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
        nameLabel.setForeground(Color.WHITE);
        nameField = new JTextField(20); // Create text field to enter name with 20 columns (characters)
        nameField.setFont(new Font("Monospaced", Font.PLAIN, 24));
        nameField.setBackground(Color.BLACK);
        nameField.setForeground(Color.WHITE);
        nameField.setBorder(null); // Remove border around text field (more command-line aesthetic)
        nameField.setCaretColor(Color.WHITE); // Set the caret color to white (blinking cursor)
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        initialPanel.add(inputPanel, BorderLayout.SOUTH);

        mainPanel.add(initialPanel, BorderLayout.CENTER);
        add(mainPanel); // Add the main panel to the frame
        pack(); // Pack frame to fit panel (meaning frame will be resized to fit panel)
        setLocationRelativeTo(null); // Center frame
        setVisible(true); // Make frame visible

        // Set focus to name field so player can start typing name immediately
        nameField.requestFocusInWindow();
    }

    // Add action listener to name field (listen for when player enters name)
    public void addNameFieldActionListener(ActionListener listener) {
        nameField.addActionListener(listener);
    }

    public String getPlayerName() {
        return nameField.getText();
    }

    // Once player has entered name, show main game view
    public void showGameView() {
        mainPanel.removeAll(); // Remove all components from main panel
        mainPanel.setLayout(new BorderLayout()); // Necessary to reset layout again

        // Create a panel to display messages
        JPanel messagePanel = new JPanel();
        messagePanel.setPreferredSize(new Dimension(700, 50));
        messagePanel.setBackground(Color.BLACK);
        messageLabel = new JLabel("Hello " + dungeonModel.getPlayer().getPlayerName() + ", Welcome to the Dungeons of Doom!"); // Label to display messages
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        messagePanel.add(messageLabel); // Add the label to the panel
        mainPanel.add(messagePanel, BorderLayout.NORTH); // Add the message panel to the frame at the top

        // Create a panel to draw the room and player on the frame
        gamePanel = new GamePanel(dungeonModel);
        // Set the preferred size of the panel based on total size of floor by cell size
        gamePanel.setPreferredSize(new Dimension(700,400));
        gamePanel.setBackground(Color.BLACK);
        mainPanel.add(gamePanel, BorderLayout.CENTER); // Add the panel to the frame

        // Create a panel to display player stats
        JPanel statsPanel = new JPanel();
        statsPanel.setPreferredSize(new Dimension(700, 50));
        statsPanel.setBackground(Color.BLACK);
        statsLabel = new JLabel(dungeonModel.getPlayer().displayStats());
        statsLabel.setForeground(Color.YELLOW);
        statsLabel.setFont(new Font("Monospaced", Font.CENTER_BASELINE, 16));
        statsPanel.add(statsLabel); // Add the label to the panel
        mainPanel.add(statsPanel, BorderLayout.SOUTH); // Add the stats panel to the frame at the bottom

        mainPanel.revalidate(); // Revalidate main panel (updates layout), necessary after adding/removing components
        mainPanel.repaint(); // Refresh the visuals of the components (e.g. color/text of a component)
        pack(); // Pack the frame to fit the panel (meaning the frame will be resized to fit the panel)
        setLocationRelativeTo(null); // Center the frame
    }

    public void refreshGameView() {
        updateStats(dungeonModel.getPlayer());
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