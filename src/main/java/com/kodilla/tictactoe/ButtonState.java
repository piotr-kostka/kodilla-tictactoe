package com.kodilla.tictactoe;

public class ButtonState {

    private final int position;
    private final String[] stateOfButton;

    public ButtonState(int position, String[] stateOfButton) {
        this.position = position;
        this.stateOfButton = stateOfButton;
    }

    public int getPosition() {
        return position;
    }

    public String[] getStateOfButton() {
        return stateOfButton;
    }
}
