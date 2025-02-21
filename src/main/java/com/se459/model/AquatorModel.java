package com.se459.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AquatorModel extends MonsterModel{
    private final Random random = new Random();

    public AquatorModel() {
        setName("Aquator");
        setScreenChar("A");
        setPositionX(0);
        setPositionY(0);
        setCarry(0);
        setFlags(List.of("M"));
        setExp(20);
        setLvl(5);
        setAmr(9);
        setDmg(0);
        setLevelsFound(new ArrayList<>());

        int hpt = 0;
        for (int i = 0; i < 5; i++) {
            int points = random.nextInt(1, 8);
            hpt+=points;
        }
        setHpt(hpt);
    }
}
