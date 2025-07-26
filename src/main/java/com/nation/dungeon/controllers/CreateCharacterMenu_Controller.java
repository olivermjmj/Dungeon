package com.nation.dungeon.controllers;

import com.nation.dungeon.util.GameManager;
import com.nation.dungeon.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreateCharacterMenu_Controller {

    @FXML private Button done;
    @FXML private Label vitalityPoint;
    @FXML private Button vitalityPlus;
    @FXML private Button vitalityMinus;
    @FXML private Button strengthMinus;
    @FXML private Button strengthPlus;
    @FXML private Label skillPoint;
    @FXML private Label strengthPoint;

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Button login;
    @FXML private Button registre;

    @FXML private ImageView background;
    @FXML private StackPane root;

    private int remainingSkillPoints;
    private int currentSkill;

    @FXML
    public void initialize() {

        remainingSkillPoints = Integer.parseInt(skillPoint.getText());

        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());

        //SkillPoint updating
        strengthPlus.setOnAction(action -> {setStrengthPlus(strengthPoint);});
        strengthMinus.setOnAction(action -> {setStrengthMinus(strengthPoint);});
        vitalityPlus.setOnAction(action -> {setVitalityPlus(vitalityPoint);});
        vitalityMinus.setOnAction(action -> {setVitalityMinus(vitalityPoint);});

        //Next scene: City menu
        done.setOnAction(action -> {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setFullScreenExitHint("");
            GameManager.get().setFullScreen(true);
            SceneManager.switchScene("cityMenu.fxml");
        });


        //Fxml styling
        strengthPlus.setOnMouseEntered(action -> {

        });

        strengthPlus.setOnMouseExited(action -> {

        });

        strengthMinus.setOnMouseEntered(action -> {

        });

        strengthMinus.setOnMouseExited(action -> {

        });

        vitalityPlus.setOnMouseEntered(action -> {

        });

        vitalityPlus.setOnMouseExited(action -> {

        });

        vitalityMinus.setOnMouseEntered(action -> {

        });

        vitalityMinus.setOnMouseExited(action -> {

        });
    }

    private void setStrengthPlus(Label skillLabel) {
        if (remainingSkillPoints > 0) {
            remainingSkillPoints--;

            currentSkill = Integer.parseInt(strengthPoint.getText());
            currentSkill++;

            strengthPoint.setText(String.valueOf(currentSkill));
            skillPoint.setText(String.valueOf(remainingSkillPoints));
        }
    }

    private void setStrengthMinus(Label skillLabel) {
        currentSkill = Integer.parseInt(strengthPoint.getText());

        if(currentSkill > 1) {
            remainingSkillPoints++;
            currentSkill--;

            strengthPoint.setText(String.valueOf(currentSkill));
            skillPoint.setText(String.valueOf(remainingSkillPoints));
        }
    }

    private void setVitalityPlus(Label skillLabel) {
        if(remainingSkillPoints > 0) {
            remainingSkillPoints--;

            currentSkill = Integer.parseInt(vitalityPoint.getText());
            currentSkill++;

            vitalityPoint.setText(String.valueOf(currentSkill));
            skillPoint.setText(String.valueOf(remainingSkillPoints));
        }
    }

    private void setVitalityMinus(Label skillLabel) {
        currentSkill = Integer.parseInt(vitalityPoint.getText());

        if(currentSkill > 1) {
            remainingSkillPoints++;
            currentSkill--;

            vitalityPoint.setText(String.valueOf(currentSkill));
            skillPoint.setText(String.valueOf(remainingSkillPoints));
        }
    }
}
