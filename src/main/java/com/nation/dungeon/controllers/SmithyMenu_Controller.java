package com.nation.dungeon.controllers;

import com.nation.dungeon.util.GameManager;
import com.nation.dungeon.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class SmithyMenu_Controller {

    //a background image for the swords to be placed on
    @FXML private ImageView weaponHolder;

    //image holders for the swords
    @FXML private ImageView sword0;
    @FXML private ImageView sword1;
    @FXML private ImageView sword2;
    @FXML private ImageView sword3;
    @FXML private ImageView sword4;
    @FXML private ImageView sword5;

    //text descriptions for the swords
    @FXML private Text sword0Description;
    @FXML private Text sword1Description;
    @FXML private Text sword2Description;
    @FXML private Text sword3Description;
    @FXML private Text sword4Description;
    @FXML private Text sword5Description;

    //buttons for going back to previous screen and being able to buy the sword that has been selected
    @FXML private Button back;
    @FXML private Button buyButton;

    //ui
    @FXML private Pane uiLayer;
    @FXML private ImageView background;
    @FXML private StackPane root;

    private ImageView selectedSword;
    private final DropShadow glowEffect = new DropShadow(30, Color.GOLD);

    @FXML
    public void initialize() {
        //Plays the background soundtrack
        //GameManager.get().audioManager().playMusic("");

        //Initializes the arrays after the FXML injection
        ImageView[] swordImageArray = new ImageView[] {sword0, sword1, sword2, sword3, sword4, sword5};
        Text[] swordDescriptionArray = new Text[]{sword0Description, sword1Description, sword2Description, sword3Description, sword4Description, sword5Description};

        //background and ui scaling
        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());
        uiLayer.prefWidthProperty().bind(root.widthProperty());
        uiLayer.prefHeightProperty().bind(root.heightProperty());

        //fxml button styling
        fxmlButtonReactStyling();

        //Sets the weapon pictures
        if(!GameManager.get().itemCombiner().items.isEmpty()) {
            for(int i = 0; i < swordImageArray.length && i < GameManager.get().itemCombiner().items.size(); i++) {
                swordImageArray[i].setImage(GameManager.get().itemCombiner().items.get(i).getImage());
            }

            //Sets the textFields to the string value of the weapon they are describing
            GameManager.get().itemCombiner().setDefaultWeaponNames();

            for (int i = 0; i < swordDescriptionArray.length && i < GameManager.get().itemCombiner().items.size(); i++) {
                swordDescriptionArray[i].setText(GameManager.get().itemCombiner().items.get(i).getDescription());
            }
        }

        //click logic for all swords
        for(ImageView sword : swordImageArray) {
            sword.setOnMouseClicked(action -> {
                //Removes the glowing effect from the last selected weapon
                if (selectedSword != null) {
                    selectedSword.setEffect(null);
                }

                //sets the current swords as the selected one and sets the glowing effect to the current weapon
                selectedSword = sword;
                selectedSword.setEffect(glowEffect);
            });
        }

        //A button for the user to be able to go back to the last menu visited
        back.setOnAction(action -> {
            //GameManager.get().audioManager().playSound("");
            SceneManager.switchScene("cityMenu.fxml");
        });

        //Buy button logic
        buyButton.setOnAction(action -> {
            if(selectedSword != null) {
                int index = -1;
                for(int i = 0; i < swordImageArray.length; i++) {
                    if(swordImageArray[i] == selectedSword) {
                        index = i;
                        break;
                    }
                }

                if(index != -1) {
                    int price = GameManager.get().itemCombiner().items.get(index).getPrice();
                    long currentUserGold = GameManager.get().getPlayer().getMoney();

                    //Negates the cost of the weapon from the users current amount of money
                    if(currentUserGold >= price) {
                        GameManager.get().getPlayer().setMoney(currentUserGold - price);

                        //Updates the player to have the weapon selected
                        GameManager.get().getPlayer().setWeapon(GameManager.get().itemCombiner().items.get(index));

                        //Updates the database to include the given weapon
                        GameManager.get().databaseManager().setUserWeapon(GameManager.get().itemCombiner().items.get(index).getDescription(), GameManager.get().getPlayer().getUsername());
                    } else {
                        //User does not have enough money
                        //GameManager.get().audioManager().playSound("");
                    }
                } else {
                    System.out.println("Something went wrong with the purchase, the item you tried to buy: " + selectedSword.getId() + " The index you hit in the array was: " + index);
                }
            }
        });
    }

    //A function made for the purpose, of making the buttons light up, when being hovered over.
    private void fxmlButtonReactStyling() {
        buyButton.setOnMouseEntered(action -> {
            //GameManager.get().audioManager().playSound("");
            buyButton.setStyle("""
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

        buyButton.setOnMouseExited(action -> {
            //GameManager.get().audioManager().playSound("");
            buyButton.setStyle("""
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
            //GameManager.get().audioManager().playSound("");
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
            //GameManager.get().audioManager().playSound("");
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