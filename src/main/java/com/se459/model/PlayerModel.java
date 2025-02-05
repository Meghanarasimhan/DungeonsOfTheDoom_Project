package com.se459.model;

public class PlayerModel {
    private int positionX;
    private int positionY;

    public PlayerModel(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }   

    public void movePlayer(int newPositionX, int newPositionY) {
        positionX = newPositionX;
        positionY = newPositionY;
    }
}
