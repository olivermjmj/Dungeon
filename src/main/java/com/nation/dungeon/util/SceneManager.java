package com.nation.dungeon.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage mainStage;

    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    public static void switchScene(String fxmlFileName) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource("/com/nation/dungeon/fxml/" + fxmlFileName));
            mainStage.setScene(new Scene(root));
        } catch (IOException e) {
            System.out.println("Error, could not fetch the .fxml file: " + e.getMessage());
        }
    }
}
