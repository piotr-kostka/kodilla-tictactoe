package com.kodilla.tictactoe;

import java.util.Arrays;

public class ButtonState {

    private int position;
    private String[] buttonState;

    public ButtonState(int position, String[] buttonState) {
        this.position = position;
        this.buttonState = buttonState;
    }

    public int getPosition() {
        return position;
    }

    public String[] getButtonState() {
        return buttonState;
    }

    @Override
    public String toString() {
        return "State{" +
                "position=" + position +
                ", state=" + Arrays.toString(buttonState) +
                '}';
    }
}
