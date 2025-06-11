package com.nation.dungeon.controllers;

import com.nation.dungeon.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class StartMenu_Controller {

    @FXML private Button login;
    @FXML private Button registre;
    @FXML private Button exit;

    @FXML private ImageView background;
    @FXML private StackPane root;

    @FXML
    public void initialize() {
        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());

        login.setOnAction(action -> {
            SceneManager.switchScene("startMenu.fxml");
        });

        exit.setOnAction(action -> {
            System.exit(0);
        });
    }
}
