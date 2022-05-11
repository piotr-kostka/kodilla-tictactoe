package com.kodilla.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private Label gameMode;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonPVP;

    @FXML
    private Button buttonAIEASY;

    @FXML
    private Button buttonAIHARD;

    @FXML
    private Button buttonEndGame;

    private int playerTurn = 0;
    private boolean PVP = false;
    private boolean computerEasy = false;
    private boolean computerHard = false;
    ArrayList<Button> gridButtons;
    EasyAI easyAI = new EasyAI();

    public void initialize() {
        onPVPButtonClick(buttonPVP);
        onAIEasyButtonClick(buttonAIEASY);
        onAIHardButtonClick(buttonAIHARD);
        gridButtons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
    }

    private void displayBoard() {
            gridButtons.forEach(this::makePlayerMove);
    }

    private void makePlayerMove(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            if (PVP) {
                if(playerTurn % 2 == 0){
                    button.setText("X");
                    label.setText("'O' move");
                    playerTurn = 1;
                } else{
                    button.setText("O");
                    label.setText("'X' move");
                    playerTurn = 0;
                }
                button.setDisable(true);
            } else if (computerEasy) {
                button.setText("X");
                button.setDisable(true);
                getComputerMove();
            } else {
                button.setText("X");
                button.setDisable(true);
                getComputerMove();
            }
        });
    }

    private void getComputerMove(){
        int move = easyAI.getAIMove(getBoardState());
        gridButtons.get(move).setText("O");
        gridButtons.get(move).setDisable(true);
    }

    private ButtonState getBoardState(){
        String[] board = new String[9];

        for (int i = 0; i < gridButtons.size(); i++) {
            board[i] = gridButtons.get(i).getText();
        }
        return new ButtonState(0,board);
    }

    private void onPVPButtonClick(Button buttonPVP) {
        buttonPVP.setOnMouseClicked(mouseEvent -> {
            disableModeButtons();
            label.setText("'X' move");
            gameMode.setText("Player vs Player");
            PVP = true;
            enableBoard();
            displayBoard();
        });
    }

    private void onAIEasyButtonClick(Button buttonAIEASY) {
        buttonAIEASY.setOnMouseClicked(mouseEvent -> {
            disableModeButtons();
            label.setText("Your move");
            gameMode.setText("Player vs Computer Easy");
            computerEasy = true;
            enableBoard();
            displayBoard();
        });
    }

    private void onAIHardButtonClick(Button buttonAIMEDIUM) {
        buttonAIMEDIUM.setOnMouseClicked(mouseEvent -> {
            disableModeButtons();
            label.setText("Your move");
            gameMode.setText("Player vs Computer Hard");
            computerHard = true;
            enableBoard();
            displayBoard();
        });
    }

    @FXML
    void closeGame() {
        Stage stage = (Stage) buttonEndGame.getScene().getWindow();
        stage.close();
    }

    @FXML
    void startNewGame() {
        disableBoard();
        clearBoard();
        enableModeButtons();
        setGameModeFalse();
        label.setText("Welcome to game");
        gameMode.setText("Select game mode:");
    }

    private void clearBoard() {
        gridButtons.forEach(button -> button.setText(""));
    }

    private void enableBoard() {
        gridButtons.forEach(button -> button.setDisable(false));
    }

    private void disableBoard() {
        gridButtons.forEach(button -> button.setDisable(true));
    }

    private void enableModeButtons() {
        buttonPVP.setDisable(false);
        buttonAIEASY.setDisable(false);
        buttonAIHARD.setDisable(false);
    }

    private void setGameModeFalse() {
        PVP = false;
        computerEasy = false;
        computerHard = false;
    }

    private void disableModeButtons() {
        buttonPVP.setDisable(true);
        buttonAIEASY.setDisable(true);
        buttonAIHARD.setDisable(true);
    }
}
