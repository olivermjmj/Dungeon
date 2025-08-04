package com.nation.dungeon.controllers;

import com.nation.dungeon.util.GameManager;
import javafx.fxml.FXML;
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

    @FXML private Pane uiLayer;
    @FXML private ImageView background;
    @FXML private StackPane root;

    @FXML
    public void initialize() {
        //GameManager.get().audioManager().playMusic("");

        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());

        uiLayer.prefWidthProperty().bind(root.widthProperty());
        uiLayer.prefHeightProperty().bind(root.heightProperty());

        //itemCombiner.items has 6 elements from the beginning
        sword0.setImage(GameManager.get().itemCombiner().items.get(0).getImage());
        sword1.setImage(GameManager.get().itemCombiner().items.get(1).getImage());
        sword2.setImage(GameManager.get().itemCombiner().items.get(2).getImage());
        sword3.setImage(GameManager.get().itemCombiner().items.get(3).getImage());
        sword4.setImage(GameManager.get().itemCombiner().items.get(4).getImage());
        sword5.setImage(GameManager.get().itemCombiner().items.get(5).getImage());
    }

}
