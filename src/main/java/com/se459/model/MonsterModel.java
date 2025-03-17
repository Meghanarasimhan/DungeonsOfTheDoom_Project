package com.se459.model;

import java.util.List;
import java.util.Random;

public class MonsterModel {

    private int positionX;
    private int positionY;

    private String screenChar;
    private String name;
    private int carry;
    private List<String> flags;
    private int exp;
    private int lvl;
    private int amr;
    private int hpt;

    private int dmg;
    private List<Integer> levelsFound;

    public MonsterModel() {
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

    public String getScreenChar() {
        return screenChar;
    }

    public void setScreenChar(String screenChar) {
        this.screenChar = screenChar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarry() {
        return carry;
    }

    public void setCarry(int carry) {
        this.carry = carry;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getAmr() {
        return amr;
    }

    public void setAmr(int amr) {
        this.amr = amr;
    }

    public int getHpt() {
        return hpt;
    }

    public void setHpt(int hpt) {
        this.hpt = hpt;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public List<Integer> getLevelsFound() {
        return levelsFound;
    }

    public void setLevelsFound(List<Integer> levelsFound) {
        this.levelsFound = levelsFound;
    }

    public int attack() {
        Random random = new Random();

        if (random.nextDouble() > 0.5) {
            return getDmg();
        } else {
            return 0;
        }
    }
}
