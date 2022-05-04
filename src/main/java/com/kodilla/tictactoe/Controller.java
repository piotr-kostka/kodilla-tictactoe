package com.kodilla.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private Label gameMode;

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private Button buttonPVP;

    @FXML
    private Button buttonAIEASY;

    @FXML
    private Button buttonAIMEDIUM;

    @FXML
    private Button buttonNewGame;

    @FXML
    private Button buttonEndGame;

    private int playerRound = 0;
    private boolean PVP = false;
    ArrayList<Button> gridButtons;
    ArrayList<Button> gameModeButtons;

    public void initialize() {
         onPVPButtonClick(buttonPVP);
    }

    public void onPVPButtonClick(Button buttonPVP) {
        gameModeButtons = new ArrayList<>(Arrays.asList(buttonPVP));
        buttonPVP.setOnMouseClicked(mouseEvent -> {
            buttonPVP.setDisable(true);
            label.setText("'X' move");
            gameMode.setText("Player vs Player");
            PVP = true;
            displayBoard();
        });
    }

    public void displayBoard() {
        gridButtons = new ArrayList<>(Arrays.asList(button00,button01,button02,button10,button11,button12,button20,button21,button22));

        gridButtons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setSymbol(button);
            button.setDisable(true);
        });
    }

    public void setSymbol(Button button){
        if (playerRound == 0){
            button.setText("X");
            button.setStyle("-fx-font-size: 70; -fx-font-weight: bold");
            label.setText("'O' move");
            playerRound = 1;
        } else {
            button.setText("O");
            button.setStyle("-fx-font-size: 70; -fx-font-weight: bold");
            label.setText("'X' move");
            playerRound = 0;
        }
    }



    public void clickButtonAIEASY() {

    }

    public void clickButtonAIMEDIUM() {

    }

    public void clickButtonNewGame() {

    }

    public void clickButtonEndGame() {

    }
}
