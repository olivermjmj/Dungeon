package com.nation.dungeon.controllers;

import com.nation.dungeon.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class CityMenu_Controller {

    @FXML public Pane uiLayer;
    @FXML private Button smithy;
    @FXML private Button arena;
    @FXML private Button upgrade;

    @FXML private ImageView background;
    @FXML private StackPane root;

    @FXML
    public void initialize() {

        //GameManager.get().audioManager().playMusic("");

        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());

        uiLayer.prefWidthProperty().bind(root.widthProperty());
        uiLayer.prefHeightProperty().bind(root.heightProperty());

        smithy.setOnAction(action -> {
            SceneManager.switchScene("smithyMenu.fxml");
            //GameManager.get().audioManager().playSound("");
        });

        arena.setOnAction(action -> {
            SceneManager.switchScene("smithyMenu.fxml");
            //GameManager.get().audioManager().playSound("");
        });

        upgrade.setOnAction(action -> {
            //GameManager.get().audioManager().playSound("");
            System.exit(0);
        });
    }

}
