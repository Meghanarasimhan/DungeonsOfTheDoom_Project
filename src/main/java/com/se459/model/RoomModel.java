package com.se459.model;

import java.util.Random;

public class RoomModel {
    private final Random r = new Random();;
    private final int numSpaces;
    private final int length;
    private final int width;
    private final char[][] room;
    private MonsterModel monsterModel = null;

    public RoomModel() {
        length = r.nextInt(3, 20);
        width = r.nextInt(3, 20);
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

    public char getCell(int width, int length) {
        return room[width][length];
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
        boolean shouldGenerateMonster = r.nextDouble() > 0.5;

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
}
