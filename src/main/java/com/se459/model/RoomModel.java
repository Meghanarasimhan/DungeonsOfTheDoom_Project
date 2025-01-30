package com.se459.model;

import java.util.Random;

public class RoomModel {
    private final Random r;
    private final int numSpaces;
    private final int length;
    private final int width;

    public RoomModel() {
        r = new Random();

        length = r.nextInt(1, 100);
        width = r.nextInt(1, 100);
        numSpaces = length * width;
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
}
