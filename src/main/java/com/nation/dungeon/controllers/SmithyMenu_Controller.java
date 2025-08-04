package com.nation.dungeon.controllers;

import com.nation.dungeon.merchant.Item;
import com.nation.dungeon.util.GameManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class SmithyMenu_Controller {

    @FXML private ImageView weaponHolder;

    @FXML private ImageView sword0;
    @FXML private ImageView sword1;
    @FXML private ImageView sword2;
    @FXML private ImageView sword3;
    @FXML private ImageView sword4;
    @FXML private ImageView sword5;

    @FXML private TextField sword0Description;
    @FXML private TextField sword1Description;
    @FXML private TextField sword2Description;
    @FXML private TextField sword3Description;
    @FXML private TextField sword4Description;
    @FXML private TextField sword5Description;

    @FXML private Pane uiLayer;
    @FXML private ImageView background;
    @FXML private StackPane root;

    private ImageView[] swordImageArray;
    private TextField[] swordDescriptionArray;

    @FXML
    public void initialize() {
        //GameManager.get().audioManager().playMusic("");

        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());

        uiLayer.prefWidthProperty().bind(root.widthProperty());
        uiLayer.prefHeightProperty().bind(root.heightProperty());

        //Sets the first 6 weapon pictures
        swordImageArray = new ImageView[] {sword0, sword1, sword2, sword3, sword4, sword5};

        for(int i = 0; i < swordImageArray.length && i < GameManager.get().itemCombiner().items.size(); i++) {
            swordImageArray[i].setImage(GameManager.get().itemCombiner().items.get(i).getImage());
        }

        //Sets the first 6 weapon descriptions
        setFirstSixWeaponNames();

        //Sets the textFields to the string value of the weapon they are describing
        for(Item item : GameManager.get().itemCombiner().items) {
            sword0Description.setText(item.getDescription());
        }
    }

    private void setFirstSixWeaponNames() {
        GameManager.get().itemCombiner().items.get(0).setDescription("Trodden wooden sword");
        GameManager.get().itemCombiner().items.get(1).setDescription("Rusty bronze sword");
        GameManager.get().itemCombiner().items.get(2).setDescription("Thoroughly worn metal sword");
        GameManager.get().itemCombiner().items.get(3).setDescription("Fine iron sword");
        GameManager.get().itemCombiner().items.get(4).setDescription("great damascus steel sword");
        GameManager.get().itemCombiner().items.get(5).setDescription("Dragon steel sword");
    }

}
