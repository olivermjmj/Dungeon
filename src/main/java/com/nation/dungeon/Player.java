package com.nation.dungeon;

import com.nation.dungeon.merchant.Item;

public class Player extends Character{

    private String password;
    private final double defenceModifier = 0.5;
    private Item weapon;

    public Player(int level, String username, String password, double strength, double currentHp, double maxHp, double defence, double currentMana, double maxMana, long money) {
        super(level, username, strength, currentHp, maxHp, defence, currentMana, maxMana, money);
        setPassword(password);
    }

    @Override
    public double tryToAttack(Character character, String attackChoice) {

        double attackDMG;

        switch (attackChoice) {
            case "light"    :   attackDMG = this.lightAttack(character);     this.takeDMG(character, attackDMG);
            break;
            case "medium"   :   attackDMG = this.mediumAttack(character);    this.takeDMG(character, attackDMG);
            break;
            case "heavy"    :   attackDMG = this.heavyAttack(character);     this.takeDMG(character, attackDMG);
            break;
            default: System.out.println("Something went wrong with tryToAttack for: Player");   attackDMG = 0;    takeDMG(character, attackDMG);
            break;
        }

        return attackDMG;   //returns what amount of damage that the attack has done
    }

    @Override
    public double lightAttack(Character character) {
        return this.getLevel() + (this.getStrength() * 0.5) - character.getDefence() * this.defenceModifier;
    }

    @Override
    public double mediumAttack(Character character) {
        return this.getLevel() + (this.getStrength() * 0.75) - character.getDefence() * this.defenceModifier;
    }

    @Override
    public double heavyAttack(Character character) {

        return this.getLevel() + this.getStrength() - character.getDefence() * this.defenceModifier;
    }

    @Override
    public void takeDMG(Character character, double damageGiven) {
        character.setCurrentHp(character.getCurrentHp() - damageGiven);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if(password != null && password.length() >= 4) {
            this.password = password;
        }
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Item getWeapon() {
        return this.weapon;
    }
}
