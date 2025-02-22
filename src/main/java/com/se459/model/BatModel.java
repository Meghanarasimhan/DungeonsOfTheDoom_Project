package com.se459.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.List.*;

public class BatModel extends MonsterModel {
    private final Random random = new Random();

    public BatModel() {
        setName("Bat");
        setScreenChar("B");
        setPositionX(0);
        setPositionY(0);
        setCarry(0);
        setFlags(Collections.singletonList("M"));
        setExp(10);    // Lower experience points compared to Aquator.
        setLvl(3);     // Lower level for a bat.
        setAmr(4);     // Lower armor value suitable for a bat.
        setDmg(0);
        setLevelsFound(new ArrayList<>());

        int hpt = 0;
        // Generate health with 3 iterations to simulate a bat's lower durability.
        for (int i = 0; i < 3; i++) {
            int points = random.nextInt(5) + 1; // Random value between 1 and 5.
            hpt += points;
        }
        setHpt(hpt);
    }
}
