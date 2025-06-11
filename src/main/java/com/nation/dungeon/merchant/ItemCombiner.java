package com.nation.dungeon.merchant;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;


public class ItemCombiner {

    private ArrayList<Item> weaponPictures = getWeaponPictures();
    private final String weaponPath = "src/main/resources/images/weaponImages";


    public ArrayList<Item> getWeaponPictures() {

        ArrayList<Item> weaponImages = new ArrayList<>();
        File weaponFolder = new File(this.weaponPath);

        File[] files = weaponFolder.listFiles();

        if(files != null) {
            for(int i = 0; i < files.length; i++) {

                File file = new File(weaponPath + "/weapon" + i + ".png");

                if(file.exists()) {
                    Image image = new Image(file.toURI().toString());
                    Item item = new Item(image);
                    weaponImages.add(item);
                }
            }
        }

        return weaponImages;
    }

    public void setWeaponNames() {

        weaponPictures.getFirst().setDescription("");
        weaponPictures.get(1).setDescription("");
        weaponPictures.get(2).setDescription("");
        weaponPictures.get(3).setDescription("");
        weaponPictures.get(4).setDescription("");
        weaponPictures.get(5).setDescription("");
    }

    public void setWeaponStats() {

        weaponPictures.getFirst().setDamageModifier(1);
        weaponPictures.get(1).setDamageModifier(1);
        weaponPictures.get(2).setDamageModifier(1);
        weaponPictures.get(3).setDamageModifier(1);
        weaponPictures.get(4).setDamageModifier(1);
        weaponPictures.get(5).setDamageModifier(1);
    }
}
