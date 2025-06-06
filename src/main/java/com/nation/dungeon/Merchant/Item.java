package com.nation.dungeon.Merchant;

import javafx.scene.image.Image;


public class Item {

    private final Image image;
    private String description;
    private double damageModifier;

    public Item(Image file) {
        this.image = file;
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

    public Image getImage() {
        return image;
    }
}
