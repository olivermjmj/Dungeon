package com.nation.dungeon.controllers;

import com.nation.dungeon.Player;
import com.nation.dungeon.util.GameManager;
import com.nation.dungeon.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class LoginRegisterMenu_Controller {

    private int level;
    private double strength;
    private double currentHp;
    private double maxHp;
    private double defence;
    private double currentMana;
    private double maxMana;
    private long money;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

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
                if(this.level == 1 && strength == 1.0 && currentHp == 100.0 && maxHp == 100.0 && defence == 1.0 && currentMana == 100.0 && maxMana == 100.0 && money == 1000) {
                    SceneManager.switchScene("createCharacterMenu.fxml");
                } else {
                    SceneManager.switchScene("cityMenu.fxml");
                }
            } else {
                //Missing
            }
        });

        register.setOnAction(action -> {
            if(tryRegister()) {
                usernameField.clear();
                passwordField.clear();
                errorLabel.setVisible(false);
            } else if(GameManager.get().databaseManager().doesUserExist(usernameField.getText(), passwordField.getText())){
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("User already exists");
                errorLabel.setVisible(true);
                //To be continued
            } else {
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("username and password must be with equal to 4 - 10 characters");
                errorLabel.setVisible(true);
            }
        });

        back.setOnAction(action -> {
            SceneManager.switchScene("startMenu.fxml");
        });

        //fxml button styling
        fxmlButtonReactStyling();
    }

    private boolean tryLogin() {
        if (usernameField != null && usernameField.getLength() <= 10) {
            if (passwordField != null && passwordField.getLength() <= 10) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                if (GameManager.get().databaseManager().doesUserExist(username, password)) {
                    // Hent alle stats fra databasen
                    this.level = GameManager.get().databaseManager().getUserLevel(username);
                    this.strength = GameManager.get().databaseManager().getUserStrength(username);
                    this.currentHp = GameManager.get().databaseManager().getUserCurrentHP(username);
                    this.maxHp = GameManager.get().databaseManager().getUserMaxHP(username);
                    this.defence = GameManager.get().databaseManager().getUserDefence(username);
                    this.currentMana = GameManager.get().databaseManager().getUserCurrentMana(username);
                    this.maxMana = GameManager.get().databaseManager().getUserMaxMana(username);
                    this.money = GameManager.get().databaseManager().getUserMoney(username);

                    //Creates player with all values from the database
                    Player newPlayer = new Player(this.level, username, password, this.strength, this.currentHp, this.maxHp, this.defence, this.currentMana, this.maxMana, this.money);

                    //Sets player in GameManager
                    GameManager.get().setPlayer(newPlayer);

                    return true;
                }
            }
        }
        return false;
    }


    private boolean tryRegister() {
        if(usernameField != null && (usernameField.getLength() <= 10 && usernameField.getLength() >= 4)) {
            if (passwordField != null && (passwordField.getLength() <= 10 && passwordField.getLength() >= 4)) {
                GameManager.get().databaseManager().createUser(usernameField.getText() ,passwordField.getText());
                return true;
            }
        }
        return false;
    }

    //A function made for the purpose, of making the buttons light up, when being hovered over.
    private void fxmlButtonReactStyling() {
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
}
