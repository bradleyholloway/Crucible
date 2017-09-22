package dev.input.util;

public class ControlButton {
    boolean prevState;
    boolean status;

    public ControlButton() {
        prevState = false;
        status = false;
    }

    public boolean update(boolean curState) {
        status = false;
        if (!prevState && curState) {
            status = true;
            prevState = true;
        }
        prevState = curState;
        return status;
    }

    public boolean getState() {
        return status;
    }
}
