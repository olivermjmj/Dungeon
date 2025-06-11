package com.nation.dungeon.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage mainStage;
    private static final String FXML_PATH = "/com/nation/dungeon/fxml/";

    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    public static void switchScene(String fxmlFileName) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource(FXML_PATH + fxmlFileName));
            mainStage.setScene(new Scene(root));
        } catch (IOException e) {
            System.out.println("Error, could not fetch the .fxml file: " + e.getMessage());
        }
    }
}
