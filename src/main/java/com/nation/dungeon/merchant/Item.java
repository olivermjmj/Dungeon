package com.nation.dungeon.merchant;

import javafx.scene.image.Image;


public class Item {

    private final Image image;
    private String description;
    private double damageModifier;
    private int price;

    public Item(Image image) {
        this.image = image;
    }

    //setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getPrice() {
        return this.price;
    }
}
