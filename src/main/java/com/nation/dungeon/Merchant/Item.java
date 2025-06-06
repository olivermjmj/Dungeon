package com.nation.dungeon.Merchant;

public class Item {

    private String description;
    private double damageModifier;

    public Item(String description, double damageModifier) {
        this.description = description;
        this.damageModifier = damageModifier;
    }

    //setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    //getters
    public String getDescription() {
        return this.description;
    }

    public double getDamageModifier() {
        return this.damageModifier;
    }
}
