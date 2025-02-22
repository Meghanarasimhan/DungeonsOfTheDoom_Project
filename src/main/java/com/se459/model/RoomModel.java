package com.se459.model;

import java.util.Random;

public class RoomModel {
    private final Random r;
    private final int numSpaces;
    private final int length;
    private final int width;
    private final char[][] room;

    public RoomModel() {
        r = new Random();
        length = r.nextInt(3, 20);
        width = r.nextInt(4, 20); // origin so that room is not too small
        this.room = new char[width][length];
        numSpaces = width * length;
        generateRoom();
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
}
