package com.kodilla.tictactoe;

public class ButtonState {

    private final int position;
    private final String[] buttonState;

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
}
