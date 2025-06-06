package com.nation.dungeon.Merchant;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Shop {

    public Shop() {

    }

    public void setWeaponStats(ItemCombiner itemCombiner) {

        ArrayList<Item> weaponPictures = itemCombiner.getWeaponPictures();

        weaponPictures.getFirst().setDescription("");
        weaponPictures.get(1).setDescription("");
        weaponPictures.get(2).setDescription("");
        weaponPictures.get(3).setDescription("");
        weaponPictures.get(4).setDescription("");
        weaponPictures.get(5).setDescription("");

        weaponPictures.getFirst().setDamageModifier(1);
        weaponPictures.get(1).setDamageModifier(1);
        weaponPictures.get(2).setDamageModifier(1);
        weaponPictures.get(3).setDamageModifier(1);
        weaponPictures.get(4).setDamageModifier(1);
        weaponPictures.get(5).setDamageModifier(1);
    }
}
