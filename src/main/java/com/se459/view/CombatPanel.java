package com.se459.view;

import com.se459.model.CombatModel;

import javax.swing.*;
import java.awt.*;

public class CombatPanel extends JPanel {
    private static final int CELL_SIZE = 20; //size of each cell in the room (40x40 pixels)
    private static final int PADDING = 20; //padding around the room (20 pixels)

    CombatModel combatModel;

    public CombatPanel(CombatModel combatModel) {
        this.combatModel = combatModel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int turn = 0;
        while (!combatModel.isBattleOver()) {
            if (turn == 0) {
                int attack = combatModel.getMonsterModel().attack();
                int currHits = combatModel.getPlayerModel().getCurrHits();
                combatModel.getPlayerModel().setCurrHits(currHits - attack);
                g.setColor(Color.RED);
                g.drawString("Monster deals " + attack + " damage!", 0, 0);
                turn = 1;
            } else {
                int attack = combatModel.getPlayerModel().attack(combatModel.getMonsterModel().getAmr());
                int currHpt= combatModel.getMonsterModel().getHpt();
                combatModel.getMonsterModel().setHpt(currHpt - attack);
                g.setColor(Color.BLUE);
                g.drawString("Player deals " + attack + " damage!", 0, 0);
                turn = 0;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (combatModel.getPlayerModel().getCurrHits() > 0) {
            int experience = combatModel.getPlayerModel().getExperience();
            combatModel.getPlayerModel().setExperience(experience + combatModel.getMonsterModel().getExp());
            g.drawString("Player gains " + combatModel.getMonsterModel().getExp() + " experience points!", 0, 0);
        }

        Container parent = this.getParent();
        if (parent != null) {
            parent.remove(this);
            parent.revalidate();
            parent.repaint();
        }
    }
}
