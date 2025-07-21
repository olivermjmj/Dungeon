package com.nation.dungeon.controllers;

import com.nation.dungeon.util.DatabaseManager;
import com.nation.dungeon.util.GameManager;
import com.nation.dungeon.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class LoginRegisterMenu_Controller {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML private Button login;
    @FXML private Button register;
    @FXML private Button back;

    @FXML private ImageView background;
    @FXML private StackPane root;

    @FXML
    public void initialize() {
        //Sets resolution
        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());

        GameManager.get().databaseManager().createDatabase();

        login.setOnAction(action -> {

            if(tryLogin()) {

                String currentUserName = GameManager.get().getPlayer().getUsername();

                GameManager.get().getPlayer().setLevel(GameManager.get().databaseManager().getUserLevel(currentUserName));
                GameManager.get().getPlayer().setCurrentHp(GameManager.get().databaseManager().getUserCurrentHP(currentUserName));
                GameManager.get().getPlayer().setMaxHp(GameManager.get().databaseManager().getUserMaxHP(currentUserName));
                GameManager.get().getPlayer().setCurrentMana(GameManager.get().databaseManager().getUserCurrentMana(currentUserName));
                GameManager.get().getPlayer().setMaxMana(GameManager.get().databaseManager().getUserMaxMana(currentUserName));
                GameManager.get().getPlayer().setDefence(GameManager.get().databaseManager().getUserDefence(currentUserName));
                GameManager.get().getPlayer().setMoney(GameManager.get().databaseManager().getUserMoney(currentUserName));
                GameManager.get().getPlayer().setStrength(GameManager.get().databaseManager().getUserStrength(currentUserName));
                SceneManager.switchScene("createCharacterMenu.fxml");
            }
        });

        register.setOnAction(action -> {
            if(tryRegister()) {

            } else {

            }
        });

        back.setOnAction(action -> {
            SceneManager.switchScene("startMenu.fxml");
        });

        //Fxml styling
        login.setOnMouseEntered(action -> {
            login.setStyle("""
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

        login.setOnMouseExited(action -> {
            login.setStyle("""
                    -fx-background-color: #FFD700;
                                       -fx-cursor: hand;
                                       -fx-text-fill: #000000;
                                       -fx-font-family: 'Comic Sans MS';
                                       -fx-font-size: 14;
                                       -fx-font-weight: bold;
                                       -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 0);
                    """);
        });

        register.setOnMouseEntered(action -> {
            register.setStyle("""
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

        register.setOnMouseExited(action -> {
            register.setStyle("""
                    -fx-background-color: #FFD700;
                                      -fx-cursor: hand;
                                      -fx-text-fill: #000000;
                                      -fx-font-family: 'Comic Sans MS';
                                      -fx-font-size: 14;
                                      -fx-font-weight: bold;
                                      -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 0);
                    """);
        });

        back.setOnMouseEntered(action -> {
            back.setStyle("""
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

        back.setOnMouseExited(action -> {
            back.setStyle("""
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

    private boolean tryLogin() {
        if(usernameField != null && usernameField.getLength() <= 10) {
            if(passwordField != null && passwordField.getLength() <= 10) {

                if(GameManager.get().databaseManager().doesUserExist(usernameField.getText(), passwordField.getText())) {
                    GameManager.get().getPlayer().setUsername(usernameField.getText());
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tryRegister() {
        if(usernameField != null && usernameField.getLength() <= 10) {
            if (passwordField != null && passwordField.getLength() <= 10) {
                GameManager.get().databaseManager().createUser(usernameField.getText() ,passwordField.getText());
                return true;
            }
        }
        return false;
    }
}
