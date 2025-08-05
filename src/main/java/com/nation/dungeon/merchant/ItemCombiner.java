package com.nation.dungeon.merchant;

import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayList;


public class ItemCombiner {

    public ArrayList<Item> items;

    //Constructor for the first 6 items
    public ItemCombiner() {
        this.items = setWeaponPictures(0, 5);

    }

    public void loadWeapons(int startIndex, int endIndex) {
        this.items = setWeaponPictures(startIndex, endIndex);
    }


    private ArrayList<Item> setWeaponPictures(int startIndex, int endIndex) {
        ArrayList<Item> weaponImages = new ArrayList<>();

        for (int i = startIndex; i <= endIndex; i++) {
            String path = "/com/nation/dungeon/images/images/weaponImages/sword" + i + ".png";

            URL url = getClass().getResource(path);
            if (url != null) {
                Image image = new Image(url.toExternalForm());
                weaponImages.add(new Item(image));
            } else {
                System.out.println("Could not find the picture on the path: " + path);
            }
        }
        return weaponImages;
    }

    //Sets the weapons default names
    public void setDefaultWeaponNames() {
        String[] names = {
                "Trodden wooden sword",
                "Rusty bronze sword",
                "Thoroughly worn metal sword",
                "Fine iron sword",
                "great damascus steel sword",
                "Dragon steel sword"
        };

        for(int i = 0; i < names.length && i < items.size(); i++) {
            items.get(i).setDescription(names[i]);
        }
    }

    //sets the weapons default prices
    public void setDefaultWeaponPrices() {
        int[] prices = {
                10,
                30,
                60,
                100,
                200,
                500
        };

        for(int i = 0; i < prices.length && i < items.size(); i++) {
            items.get(i).setPrice(prices[i]);
        }
    }
}
