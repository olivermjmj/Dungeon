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

            if(mainStage.getScene() == null) {
                // første gang, opret scenen
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
            } else {
                //Uses the original scene, while swapping out the content inside
                mainStage.getScene().setRoot(root);
            }

            // Sørg for at fullscreen genaktiveres EFTER scene-skift
            if(GameManager.get().isFullScreen()) {
                javafx.application.Platform.runLater(() -> mainStage.setFullScreen(true));
            } else {
                mainStage.setFullScreen(false);
            }

        } catch (IOException e) {
            System.out.println("Error, could not fetch the .fxml file: " + e.getMessage());
        }
    }

}
