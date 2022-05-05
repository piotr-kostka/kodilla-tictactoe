package com.kodilla.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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
    private int column;
    private int row;
    private boolean PVP = false;
    private boolean AIMedium = false;
    private boolean AIEasy = false;
    ArrayList<Button> gridButtons;
    char[][] game = new char[3][3];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         onPVPButtonClick(buttonPVP);
         onAIEasyButtonClick(buttonAIEASY);
         onAIMediumButtonClick(buttonAIMEDIUM);
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
            column = GridPane.getColumnIndex(button);
            row = GridPane.getRowIndex(button);
            System.out.println(column + " " + row);
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

    public void onPVPButtonClick(Button buttonPVP) {

        buttonPVP.setOnMouseClicked(mouseEvent -> {
            buttonPVP.setDisable(true);
            buttonAIMEDIUM.setDisable(true);
            buttonAIEASY.setDisable(true);
            buttonPVP.setFocusTraversable(false);
            label.setText("'X' move");
            gameMode.setText("Player vs Player");
            PVP = true;
            displayBoard();
        });
    }

    public void onAIEasyButtonClick(Button buttonAIEASY) {

        buttonAIEASY.setOnMouseClicked(mouseEvent -> {
            buttonAIEASY.setDisable(true);
            buttonPVP.setDisable(true);
            buttonAIMEDIUM.setDisable(true);
            buttonAIEASY.setFocusTraversable(false);
            label.setText("'X' move");
            gameMode.setText("Player vs Computer Easy");
            AIEasy = true;
            displayBoard();
        });
    }

    public void onAIMediumButtonClick(Button buttonAIMEDIUM) {

        buttonAIMEDIUM.setOnMouseClicked(mouseEvent -> {
            buttonAIMEDIUM.setDisable(true);
            buttonPVP.setDisable(true);
            buttonAIEASY.setDisable(true);
            buttonAIMEDIUM.setFocusTraversable(false);
            label.setText("'X' move");
            gameMode.setText("Player vs Computer Medium");
            AIMedium = true;
            displayBoard();
        });
    }

    public void clickButtonNewGame() {

    }

    public void clickButtonEndGame() {

    }
}
