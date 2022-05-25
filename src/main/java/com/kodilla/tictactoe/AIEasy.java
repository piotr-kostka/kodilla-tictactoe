package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class AIEasy {
    Random random = new Random();

    public int getComputerEasyMove(ButtonState buttonState) {
        int drawNumber;
        ArrayList<ButtonState> possibleMoves = getEmptyStates(buttonState);
        ArrayList<Integer> movesList = new ArrayList<>();

        for (ButtonState states: possibleMoves) {
            movesList.add(states.getPosition());
        }
        drawNumber = random.nextInt(movesList.size());

        return possibleMoves.get(drawNumber).getPosition();
    }

    ArrayList<ButtonState> getEmptyStates(ButtonState buttonState) {
        ArrayList<ButtonState> possibleMoves = new ArrayList<>();
        String player = "";

        for (int i = 0; i < 9; i++) {
            String[] newState = buttonState.getButtonState();

            if (!Objects.equals(newState[i], "X") && !Objects.equals(newState[i], "O")){
                newState[i] = player;
                possibleMoves.add(new ButtonState(i, newState));
            }
        }
        return possibleMoves;
    }
}


