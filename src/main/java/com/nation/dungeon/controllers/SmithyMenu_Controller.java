package com.nation.dungeon.controllers;

import com.nation.dungeon.util.GameManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class SmithyMenu_Controller {

    @FXML private ImageView weaponHolder;

    @FXML private ImageView sword0;
    @FXML private ImageView sword1;
    @FXML private ImageView sword2;
    @FXML private ImageView sword3;
    @FXML private ImageView sword4;
    @FXML private ImageView sword5;

    @FXML private Text sword0Description;
    @FXML private Text sword1Description;
    @FXML private Text sword2Description;
    @FXML private Text sword3Description;
    @FXML private Text sword4Description;
    @FXML private Text sword5Description;

    @FXML private Pane uiLayer;
    @FXML private ImageView background;
    @FXML private StackPane root;

    @FXML
    public void initialize() {
        //Plays the background soundtrack
        //GameManager.get().audioManager().playMusic("");

        //Initializes the arrays after the FXML injection
        ImageView[] swordImageArray = new ImageView[] {sword0, sword1, sword2, sword3, sword4, sword5};
        Text[] swordDescriptionArray = new Text[]{sword0Description, sword1Description, sword2Description, sword3Description, sword4Description, sword5Description};


        //background and ui scaling
        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());
        uiLayer.prefWidthProperty().bind(root.widthProperty());
        uiLayer.prefHeightProperty().bind(root.heightProperty());

        //Sets the weapon pictures
        if(!GameManager.get().itemCombiner().items.isEmpty()) {
            for(int i = 0; i < swordImageArray.length && i < GameManager.get().itemCombiner().items.size(); i++) {
                swordImageArray[i].setImage(GameManager.get().itemCombiner().items.get(i).getImage());
            }

            //Sets the textFields to the string value of the weapon they are describing
            GameManager.get().itemCombiner().setDefaultWeaponNames();

            for (int i = 0; i < swordDescriptionArray.length && i < GameManager.get().itemCombiner().items.size(); i++) {
                swordDescriptionArray[i].setText(GameManager.get().itemCombiner().items.get(i).getDescription());
            }
        }
    }
}