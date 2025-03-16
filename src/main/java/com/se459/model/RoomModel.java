package com.se459.model;

import java.util.Random;

public class RoomModel {
    private final Random r = new Random();
    private final int numSpaces;
    private final int length;
    private final int width;
    private final char[][] room;
    private MonsterModel monsterModel = null;
    private GoldModel goldModel = null;
    // coordinates of stairs
    private int stairPositionX;   
    private int stairPositionY;

    public RoomModel() {
        length = r.nextInt(3, 20);
        width = r.nextInt(4, 20); // origin so that room is not too small
        this.room = new char[width][length];
        numSpaces = width * length;
        generateRoom();
        generateMonster();
        generateStairs();
        generateGold();
    }

    public int getNumSpaces() {
        return numSpaces;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public char getCell(int width, int length) {
        return room[width][length];
    }

    public boolean isWall(int xCoordinate, int yCoordinate) {
        return room[xCoordinate][yCoordinate] == '#';
    }

    public boolean isGold(int xCoordinate, int yCoordinate) {
        return goldModel != null && goldModel.getPositionX() == xCoordinate && goldModel.getPositionY() == yCoordinate;
    }

    public MonsterModel getMonsterModel() {
        return monsterModel;
    }

    public void setMonsterModel(MonsterModel monsterModel) {
        this.monsterModel = monsterModel;
    }

    public GoldModel getGoldModel() {
        return goldModel;
    }

    public void setGoldModel(GoldModel goldModel) {
        this.goldModel = goldModel;
    }

    // Initialize the room with walls and dots (for different positions)
    private void generateRoom() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                // if the position is on the border, set it as a wall
                if (i == 0 || i == width - 1 || j == 0 || j == length - 1) {
                    room[i][j] = '#';
                } else {
                    room[i][j] = '.'; // otherwise, set it as a dot
                }
            }
        }
    }

    private void generateMonster() {
        boolean shouldGenerateMonster = r.nextDouble() > 0.25;

        if (shouldGenerateMonster) {
            int monster = r.nextInt(1, 3);

            switch (monster) {
                case 1:
                    AquatorModel aquator = new AquatorModel();
                    int xPos = r.nextInt(1, width - 1);
                    int yPos = r.nextInt(1, length - 1);
                    aquator.setPositionX(xPos);
                    aquator.setPositionY(yPos);
                    setMonsterModel(aquator);
                    break;
                default:
                    break;
            }
        }
    }

    private void generateGold() {
        boolean shouldGenerateGold = r.nextInt(3) == 0; // 1 in 3 chance of generating gold

        if (shouldGenerateGold) {
            GoldModel newGoldModel = new GoldModel();
            int xPos = 0;
            int yPos = 0;
            do {
                xPos = r.nextInt(getWidth());
                yPos = r.nextInt(getLength());
            } while (isWall(xPos, yPos) || isStairs(xPos, yPos)); // continue looping until gold is not on a wall or stairs
           
            newGoldModel.setPositionX(xPos);
            newGoldModel.setPositionY(yPos);     
            setGoldModel(newGoldModel);       
        }
    }

    private void generateStairs() {
        do {
            stairPositionX = r.nextInt(getWidth());
            stairPositionY = r.nextInt(getLength());
        } while (isWall(stairPositionX, stairPositionY)); // continue looping until stairs are not on a wall
        room[stairPositionX][stairPositionY] = '%';
    }   

    public boolean isStairs(int x, int y) {
        return (x == stairPositionX && y == stairPositionY);
    }
    
}
