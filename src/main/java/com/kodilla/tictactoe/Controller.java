package com.kodilla.tictactoe;

import javafx.event.ActionEvent;
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
    private boolean AIEasy = false;
    private boolean AIHard = false;
    ArrayList<Button> gridButtons;
    EasyAI easyAI = new EasyAI();

    public void initialize() {
        onPVPButtonClick(buttonPVP);
        onAIEasyButtonClick(buttonAIEASY);
        onAIHardButtonClick(buttonAIHARD);
    }

    public void displayBoard() {
        gridButtons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        if(AIEasy) {
            gridButtons.forEach(this::setupButtonVsAI);
        } else if (PVP) {
            gridButtons.forEach(this::setupButtonVsPVP);
        }
    }

    private void setupButtonVsAI(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setSymbolVsAI(button);
            button.setDisable(true);
            makeAIMove();
        });
    }

    public void makeAIMove(){
        int move = easyAI.getAIMove(getBoardState());
        gridButtons.get(move).setText("O");
        gridButtons.get(move).setDisable(true);
    }

    public void setSymbolVsAI(Button button){
        button.setText("X");
    }

    public ButtonState getBoardState(){
        String[] board = new String[9];

        for (int i = 0; i < gridButtons.size(); i++) {
            board[i] = gridButtons.get(i).getText();
        }

        return new ButtonState(0,board);
    }


    private void setupButtonVsPVP(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setSymbolVsPVP(button);
            button.setDisable(true);
        });
    }

    public void setSymbolVsPVP (Button button){
        if(playerTurn % 2 == 0){
            button.setText("X");
            label.setText("'O' move");
            playerTurn = 1;
        } else{
            button.setText("O");
            label.setText("'X' move");
            playerTurn = 0;
        }
    }

    public void onPVPButtonClick(Button buttonPVP) {
        buttonPVP.setOnMouseClicked(mouseEvent -> {
            buttonPVP.setDisable(true);
            buttonAIHARD.setDisable(true);
            buttonAIEASY.setDisable(true);
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
            buttonAIHARD.setDisable(true);
            label.setText("'X' move");
            gameMode.setText("Player vs Computer Easy");
            AIEasy = true;
            displayBoard();
        });
    }

    public void onAIHardButtonClick(Button buttonAIMEDIUM) {
        buttonAIMEDIUM.setOnMouseClicked(mouseEvent -> {
            buttonAIMEDIUM.setDisable(true);
            buttonPVP.setDisable(true);
            buttonAIEASY.setDisable(true);
            label.setText("'X' move");
            gameMode.setText("Player vs Computer Medium");
            AIHard = true;
            displayBoard();
        });
    }

    @FXML
    void closeGame(ActionEvent event) {
        Stage stage = (Stage) buttonEndGame.getScene().getWindow();
        stage.close();
    }

    @FXML
    void startNewGame(ActionEvent event) {
        gridButtons.forEach(button -> {
                button.setDisable(false);
                button.setText("");
            });
        buttonPVP.setDisable(false);
        buttonAIEASY.setDisable(false);
        buttonAIHARD.setDisable(false);
        label.setText("Welcome to game");
        gameMode.setText("Select game mode:");
        PVP = false;
        AIEasy = false;
    }
}
