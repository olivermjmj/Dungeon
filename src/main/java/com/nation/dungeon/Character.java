package com.nation.dungeon;

public abstract class Character {

    private int level;
    private String username;

    private double strength;
    private double currentHp;
    private double maxHp;
    private double defence;
    private double currentMana;
    private double maxMana;
    private long money;

    public Character(int level, String username, double strength, double currentHp, double maxHp, double defence, double currentMana, double maxMana, long money) {
        this.level = level;
        this.username = username;
        this.strength = strength;
        this.currentHp = currentHp;
        this.maxHp = maxHp;
        this.defence = defence;
        this.currentMana = currentMana;
        this.maxMana = maxMana;
        this.money = money;
    }

    //attack
    public abstract double tryToAttack(Character character, String attackChoice);
    public abstract double lightAttack(Character character);
    public abstract double mediumAttack(Character character);
    public abstract double heavyAttack(Character character);
    public abstract void takeDMG(Character character, double damageGiven);

    //getters
    public int getLevel() {return this.level;}
    public String getUsername() {return this.username;}
    public double getStrength() {return this.strength;}
    public double getCurrentHp() {return this.currentHp;}
    public double getMaxHp() {return this.currentHp;}
    public double getDefence() {return this.defence;}
    public double getCurrentMana() {return this.currentMana;}
    public double getMaxMana() {return this.maxMana;}
    public long getMoney() {return money;}

    //setters
    public void setLevel(int level) {this.level = level;}
    public void setUsername(String username) {this.username = username;}
    public void setStrength(double strength) {this.strength = strength;}
    public void setCurrentHp(double currentHp) {this.currentHp = currentHp;}
    public void setMaxHp(double maxHp) {this.maxHp = maxHp;}
    public void setDefence(double defence) {this.defence = defence;}
    public void setCurrentMana(double currentMana) {this.currentMana = currentMana;}
    public void setMaxMana(double maxMana) {this.maxMana = maxMana;}
    public void setMoney(long money) {this.money = money;}
}
