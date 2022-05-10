package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gameTemplate.fxml"))));
        Image icon = new Image(getClass().getResourceAsStream("logo.jpg"));

        primaryStage.setTitle("TicTacToe - by P.Kostka");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }
}