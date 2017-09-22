package dev.game;

import dev.input.util.VirtualJoystick;

public class CameraFocus {
    private int xOffset;
    private int yOffset;
    private final double cameraSensitivity = 16;

    public CameraFocus(int x, int y) {
        xOffset = x;
        yOffset = y;
    }

    public void move(int x, int y) {
        moveTo(xOffset + x, yOffset + y);
    }

    public void move(double x, double y) {
        move((int) x, (int) y);
    }

    public void move(VirtualJoystick joystick) {
        move(joystick.getXAxis() * cameraSensitivity, joystick.getYAxis() * cameraSensitivity);
    }

    public void moveTo(int x, int y) {
        xOffset = x;
        yOffset = y;
    }

    public int getX() {
        return xOffset;
    }

    public int getY() {
        return yOffset;
    }
}
