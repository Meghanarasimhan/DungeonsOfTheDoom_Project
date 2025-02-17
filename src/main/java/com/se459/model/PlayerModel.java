package com.se459.model;

public class PlayerModel {
    private int positionX;
    private int positionY;

    // Initial player stats
    public static final int MINIMUM_STRENGTH = 3;
    public static final int MAXIMUM_STRENGTH = 31;
    private int level = 1;
    private int currHits = 12; // number of health points player has
    private int maxHits = 12;    
    private int strength = 16; 
    private int gold = 0;
    private int armor = 10; // signifying nothing (i.e. no armor)
    private int experience = 0; // still confused by what exactly this is (i.e. how it's measured)

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

    public int getLevel() {
        return level;
    }

    public int getCurrHits() {
        return currHits;
    }

    public int getMaxHits() {
        return maxHits;
    }   

    public int getStrength() {
        return strength;
    }   

    public int getGold() {
        return gold;
    }       

    public int getArmor() {
        return armor;
    }

    public int getExperience() {
        return experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrHits(int currHits) {
        this.currHits = currHits;
    }   

    public void setMaxHits(int maxHits) {
        this.maxHits = maxHits;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String displayStats() {
        return "Level:" + level + 
        "    Hits:" + currHits + "(" + maxHits + ")" + 
        "    Str:" + strength + 
        "    Gold:" + gold + 
        "    Armor:" + armor + 
        "    Exp:" + level + "/" + experience;
    }

}
