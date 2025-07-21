package com.nation.dungeon.controllers;

import com.nation.dungeon.util.GameManager;
import com.nation.dungeon.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StartMenu_Controller {

    @FXML private Button play;
    @FXML private Button guest;
    @FXML private Button exit;

    @FXML private ImageView background;
    @FXML private StackPane root;

    @FXML
    public void initialize() {
        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());

        play.setOnAction(action -> {
            SceneManager.switchScene("loginRegisterMenu.fxml");
        });

        guest.setOnAction(action -> {
            SceneManager.switchScene("createCharacterMenu.fxml");
        });

        exit.setOnAction(action -> {
            System.exit(0);
        });

        //Fxml styling
        play.setOnMouseEntered(action -> {
            play.setStyle("""
                    -fx-background-color: #FFD700;
                                       -fx-cursor: hand;
                                       -fx-text-fill: #000000;
                                       -fx-font-family: 'Comic Sans MS';
                                       -fx-font-size: 14;
                                       -fx-font-weight: bold;
                                       -fx-min-height: 40;
                                       -fx-effect: dropshadow(three-pass-box, rgba(255,215,0,0.8), 15, 0.5, 0, 0);
                                       -fx-border-color: #DAA520;
                                       -fx-border-width: 2;
                                       -fx-background-radius: 5;
                                       -fx-border-radius: 5;
                    """);
        });

        play.setOnMouseExited(action -> {
            play.setStyle("""
                    -fx-background-color: #FFD700;
                                       -fx-cursor: hand;
                                       -fx-text-fill: #000000;
                                       -fx-font-family: 'Comic Sans MS';
                                       -fx-font-size: 14;
                                       -fx-font-weight: bold;
                                       -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 0);
                    """);
        });

        guest.setOnMouseEntered(action -> {
            guest.setStyle("""
                    -fx-background-color: #FFD700;
                                       -fx-cursor: hand;
                                       -fx-text-fill: #000000;
                                       -fx-font-family: 'Comic Sans MS';
                                       -fx-font-size: 14;
                                       -fx-font-weight: bold;
                                       -fx-min-height: 40;
                                       -fx-effect: dropshadow(three-pass-box, rgba(255,215,0,0.8), 15, 0.5, 0, 0);
                                       -fx-border-color: #DAA520;
                                       -fx-border-width: 2;
                                       -fx-background-radius: 5;
                                       -fx-border-radius: 5;
                    """);
        });

        guest.setOnMouseExited(action -> {
            guest.setStyle("""
                    -fx-background-color: #FFD700;
                                      -fx-cursor: hand;
                                      -fx-text-fill: #000000;
                                      -fx-font-family: 'Comic Sans MS';
                                      -fx-font-size: 14;
                                      -fx-font-weight: bold;
                                      -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 0);
                    """);
        });

        exit.setOnMouseEntered(action -> {
            exit.setStyle("""
                    -fx-background-color: #FFD700;
                                       -fx-cursor: hand;
                                       -fx-text-fill: #000000;
                                       -fx-font-family: 'Comic Sans MS';
                                       -fx-font-size: 14;
                                       -fx-font-weight: bold;
                                       -fx-min-height: 40;
                                       -fx-effect: dropshadow(three-pass-box, rgba(255,215,0,0.8), 15, 0.5, 0, 0);
                                       -fx-border-color: #DAA520;
                                       -fx-border-width: 2;
                                       -fx-background-radius: 5;
                                       -fx-border-radius: 5;
                    """);
        });

        exit.setOnMouseExited(action -> {
            exit.setStyle("""
                    -fx-background-color: #FFD700;
                                       -fx-cursor: hand;
                                       -fx-text-fill: #000000;
                                       -fx-font-family: 'Comic Sans MS';
                                       -fx-font-size: 14;
                                       -fx-font-weight: bold;
                                       -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 0);
                    """);
        });
    }
}
