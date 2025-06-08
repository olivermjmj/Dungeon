package com.nation.dungeon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Button login;
    private Button registre;
    private Button exit;

    @FXML
    protected void onHelloButtonClick() {
        login.setText("Welcome to JavaFX Application!");
    }
}