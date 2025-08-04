package com.nation.dungeon.controllers;

import com.nation.dungeon.merchant.Item;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class SmithyMenu_Controller {

    @FXML public ImageView sword0;

    @FXML private ImageView background;
    @FXML private StackPane root;

    @FXML
    public void initialize() {

        //GameManager.get().audioManager().playMusic("");

        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());


        Image image = new Image("/com/nation/dungeon/images/sword0");
        Item item = new Item(image);
        sword0.setImage(item.getImage());
    }

}
