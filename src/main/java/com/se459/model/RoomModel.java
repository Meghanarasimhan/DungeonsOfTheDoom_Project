package com.se459.model;

import java.util.Random;

public class RoomModel {
    private final Random r = new Random();
    private final int numSpaces;
    private final int length;
    private final int width;
    private final char[][] room;
    private MonsterModel monsterModel = null;

    public RoomModel() {
        length = r.nextInt(18) + 3;
        width = r.nextInt(18) + 3;
        this.room = new char[width][length];
        numSpaces = width * length;
        generateRoom();
        generateMonster();
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

    public char getCell(int x, int y) {
        return room[x][y];
    }

    public boolean isWall(int xCoordinate, int yCoordinate) {
        return room[xCoordinate][yCoordinate] == '#';
    }

    public MonsterModel getMonsterModel() {
        return monsterModel;
    }

    public void setMonsterModel(MonsterModel monsterModel) {
        this.monsterModel = monsterModel;
    }

    // Initialize the room with walls around the border and dots inside.
    private void generateRoom() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                // Set border cells as walls.
                if (i == 0 || i == width - 1 || j == 0 || j == length - 1) {
                    room[i][j] = '#';
                } else {
                    room[i][j] = '.'; // inner cells are open space.
                }
            }
        }
    }

    // Generate a Bat monster in the room based on a random chance.
    private void generateMonster() {
        boolean shouldGenerateMonster = r.nextDouble() > 0.5;

        if (shouldGenerateMonster) {
            BatModel bat = new BatModel();
            int xPos = r.nextInt(width - 2) + 1;
            int yPos = r.nextInt(length - 2) + 1;
            bat.setPositionX(xPos);
            bat.setPositionY(yPos);
            monsterModel = bat;
        }
    }
}
