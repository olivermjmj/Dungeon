package com.nation.dungeon;

public class Enemy extends Character{

    private final double defenceModifier = 0.5;

    public Enemy(int level, String username, double strength, double currentHp, double maxHp, double defence, double currentMana, double maxMana, long money) {
        super(level, username, strength, currentHp, maxHp, defence, currentMana, maxMana, money);
    }

    @Override
    public double tryToAttack(Character character, String attackChoice) {

        double attackDMG;

        switch (attackChoice) {
            case "light"    :   attackDMG = this.lightAttack(character);     takeDMG(character, attackDMG);
            break;
            case "medium"   :   attackDMG = this.mediumAttack(character);    takeDMG(character, attackDMG);
            break;
            case "heavy"    :   attackDMG = this.heavyAttack(character);     takeDMG(character, attackDMG);
            break;
            default         :   System.out.println("Something went wrong with tryToAttack for: Enemy");    attackDMG = 0;    takeDMG(character, attackDMG);
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
}
