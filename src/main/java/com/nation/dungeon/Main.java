package com.nation.dungeon;

import com.nation.dungeon.util.GameManager;
import com.nation.dungeon.util.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCharacterCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/startMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 853, 480);
        stage.setTitle("Mænd der slås");
        stage.setScene(scene);
        stage.setResizable(false);
        //Removes the users ability to accidentally exit fullscreen
        //stage.setFullScreenExitKeyCombination(new KeyCharacterCombination(null));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}