package com.kodilla.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @FXML
    private Label score;

    private int playerTurn = 0;
    private boolean PVP = false;
    private boolean computerEasy = false;
    private int playerScore = 0;
    private int player2Score = 0;
    private int computerScore = 0;
    private int movesCounter = 0;
    private boolean checkWin = false;
    ArrayList<Button> gridButtons;

    AI AI = new AI();

    public void initialize() {
        onPVPButtonClick(buttonPVP);
        onAIEasyButtonClick(buttonAIEASY);
        gridButtons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
    }

    private void displayBoard() {
            gridButtons.forEach(this::makeMove);
    }

    private void makeMove(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            if (PVP) {
                setPlayerMove(button);
            } else if (computerEasy) {
                setPlayerMoveAgainstComputer(button);
                if (movesCounter <9 && !checkWin) {
                    getComputerMove();
                }
            }
        });
    }

    private void setPlayerMove(Button button) {
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
        movesCounter++;
        checkWin();
        disableBoardButtonsAfterWin();
        checkDraw();
    }

    private void setPlayerMoveAgainstComputer(Button button) {
        button.setText("X");
        button.setDisable(true);
        movesCounter++;
        checkWin();
        disableBoardButtonsAfterWin();
        checkDraw();
    }

    private void getComputerMove(){
        int move = AI.getEasyMove(getBoardState());
        gridButtons.get(move).setText("O");
        gridButtons.get(move).setDisable(true);
        movesCounter++;
        checkWin();
        disableBoardButtonsAfterWin();
        checkDraw();
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
            enableBoardButtons();
            displayBoard();
        });
    }

    private void onAIEasyButtonClick(Button buttonAIEASY) {
        buttonAIEASY.setOnMouseClicked(mouseEvent -> {
            disableModeButtons();
            label.setText("Your move");
            gameMode.setText("Player vs Computer Easy");
            computerEasy = true;
            enableBoardButtons();
            displayBoard();
        });
    }


    private List<String> getWiningLine() {
        List<String> winingLines = new ArrayList<>();

        winingLines.add(button1.getText() + button2.getText() + button3.getText());
        winingLines.add(button4.getText() + button5.getText() + button6.getText());
        winingLines.add(button7.getText() + button8.getText() + button9.getText());
        winingLines.add(button1.getText() + button5.getText() + button9.getText());
        winingLines.add(button3.getText() + button5.getText() + button7.getText());
        winingLines.add(button1.getText() + button4.getText() + button7.getText());
        winingLines.add(button2.getText() + button5.getText() + button8.getText());
        winingLines.add(button3.getText() + button6.getText() + button9.getText());

        return winingLines;
    }

    private void checkWin() {
        for(String lines : getWiningLine()) {
            if (PVP) {
                if (lines.equals("XXX")) {
                    label.setText("X won!");
                    checkWin = true;
                    playerScore++;
                } else if (lines.equals("OOO")) {
                    label.setText("O won!");
                    checkWin = true;
                    player2Score++;
                }
                score.setText("Player X " + playerScore + " - " + player2Score + " Player O");
            } else if (computerEasy) {
                if (lines.equals("XXX")) {
                    label.setText("You won!");
                    label.setStyle("-fx-text-fill: green");
                    checkWin = true;
                    playerScore++;
                } else if (lines.equals("OOO")) {
                    label.setText("Computer won!");
                    label.setStyle("-fx-text-fill: red");
                    checkWin = true;
                    computerScore++;
                }
                score.setText("Player  " + playerScore + " - " + computerScore + " Computer");
            }
        }
    }

    private void disableBoardButtonsAfterWin() {
        if (checkWin) {
            disableBoardButtons();
        }
    }

    private void checkDraw() {
        if (movesCounter == 9 && !checkWin) {
            label.setText("Draw! No points!");
        }
    }

    @FXML
    void closeGame() {
        Stage stage = (Stage) buttonEndGame.getScene().getWindow();
        stage.close();
    }

    @FXML
    void startNewGame() {
        disableBoardButtons();
        clearBoard();
        enableModeButtons();
        setModeButtonsFalse();
        playerTurn = 0;
        movesCounter = 0;
        checkWin = false;
        playerScore = 0;
        player2Score = 0;
        computerScore = 0;
        label.setText("Welcome to game");
        label.setStyle("-fx-text-fill: black");
        gameMode.setText("Select game mode:");
        score.setText("");
    }

    @FXML
    void playAgain() {
        clearBoard();
        enableBoardButtons();
        checkWin = false;
        movesCounter = 0;
        if (playerTurn == 0) {
            label.setText("'X' move");
        } else {
            label.setText("'O' move");
        }
        label.setStyle("-fx-text-fill: black");
    }

    private void clearBoard() {
        gridButtons.forEach(button -> button.setText(""));
    }

    private void enableBoardButtons() {
        gridButtons.forEach(button -> button.setDisable(false));
    }

    private void disableBoardButtons() {
        gridButtons.forEach(button -> button.setDisable(true));
    }

    private void enableModeButtons() {
        buttonPVP.setDisable(false);
        buttonAIEASY.setDisable(false);
    }

    private void disableModeButtons() {
        buttonPVP.setDisable(true);
        buttonAIEASY.setDisable(true);
    }

    private void setModeButtonsFalse() {
        PVP = false;
        computerEasy = false;
    }
}
