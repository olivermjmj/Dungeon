package com.nation.dungeon.Merchant;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;


public class ItemCombiner {

    private final String weaponPath = "src/main/resources/images/weaponImages";

    public ArrayList<Image> getWeaponPictures() {

        ArrayList<Image> weaponImages = new ArrayList<>();
        File weaponFolder = new File(this.weaponPath);

        File[] files = weaponFolder.listFiles();

        if(files != null) {
            for(int i = 0; i < files.length; i++) {

                File file = new File(weaponPath + "/weapon" + i + ".png");

                if(file.exists()) {
                    Image image = new Image(file.toURI().toString());
                    weaponImages.add(image);
                }
            }
        }

        return weaponImages;
    }
}
