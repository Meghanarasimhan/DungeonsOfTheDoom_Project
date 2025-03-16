package com.se459.model;

import java.util.Random;

public class GoldModel {
    
    private int positionX;
    private int positionY;
    private final Random r = new Random();

    private int amount;

    public GoldModel() {
    }   

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int floorLevel) {
        // amount of gold will be a random number between 2 and (50 + 10*level)
        this.amount = r.nextInt(2, (50 + 10 * floorLevel));
    }
}
