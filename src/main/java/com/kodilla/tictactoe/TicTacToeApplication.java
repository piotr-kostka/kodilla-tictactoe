package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gameTemplate.fxml")));
        primaryStage.setTitle("TicTacToe - by P.Kostka");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }
}