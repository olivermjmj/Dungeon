package com.nation.dungeon.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class SmithyMenu_Controller {


    @FXML private ImageView sword0;

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
    }

}
