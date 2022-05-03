package com.kodilla.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

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
    private Button buttonClearBoard;

    @FXML
    private Button buttonNewGame;

    @FXML
    private Button buttonEndGame;

    public void clickButton00() {
        System.out.println("00");
        button00.setText("X");
        button00.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButton01() {
        button01.setText("X");
        button01.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButton02() {
        button02.setText("X");
        button02.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButton10() {
        button10.setText("X");
        button10.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButton11() {
        button11.setText("X");
        button11.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButton12() {
        button12.setText("X");
        button12.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButton20() {
        button20.setText("X");
        button20.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButton21() {
        button21.setText("X");
        button21.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButton22() {
        button22.setText("X");
        button22.setStyle("-fx-font-size: 75; -fx-font-weight: bold");
    }

    public void clickButtonPVP() {

    }

    public void clickButtonAIEASY() {

    }

    public void clickButtonAIMEDIUM() {

    }

    public void clickButtonClearBoard() {

    }

    public void clickButtonNewGame() {

    }

    public void clickButtonEndGame() {

    }
}
