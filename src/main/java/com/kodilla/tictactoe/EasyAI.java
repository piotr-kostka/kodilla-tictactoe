package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class EasyAI {
    Random random = new Random();

    public int getAIMove(ButtonState buttonState) {

        int drawNumber;
        ArrayList<ButtonState> possibleMoves = emptyPlaces(buttonState);
        ArrayList<Integer> movesList = new ArrayList<>();

        for (ButtonState states: possibleMoves) {
            movesList.add(states.getPosition());
        }

        if (movesList.size()>1) {
            drawNumber = random.nextInt(movesList.size());
        } else {
            return 0;
        }

        return possibleMoves.get(drawNumber).getPosition();
    }



    private ArrayList<ButtonState> emptyPlaces(ButtonState buttonState){
        ArrayList<ButtonState> possibleMoves = new ArrayList<>();
        int xMoves = 0;
        int oMoves = 0;
        String player;

        //Sprawdzenie czyja tura
        for (String turn: buttonState.getStateOfButton()) {
            if (turn.equals("X")) {
                xMoves++;
            }else if(turn.equals("O")){
                oMoves++;
            }
        }

        if(xMoves <= oMoves){
            player = "X";
        } else {
            player = "O";
        }

        //Stworzenie listy mozliwych ruchów gdzie pole buttona jest wolne
        for (int i = 0; i < 9; i++) {
            String[] newState = buttonState.getStateOfButton().clone();

            if(!Objects.equals(newState[i], "X") && !Objects.equals(newState[i], "O")){
                newState[i] = player;
                possibleMoves.add(new ButtonState(i, newState));
            }
        }
        return possibleMoves;
    }
}


