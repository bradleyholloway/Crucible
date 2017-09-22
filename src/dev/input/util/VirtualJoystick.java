package dev.input.util;

public class VirtualJoystick {
    private int kUp;
    private int kDown;
    private int kLeft;
    private int kRight;
    private double xAxis;
    private double yAxis;
    private KeyboardState ks;

    public VirtualJoystick(int kUp, int kDown, int kLeft, int kRight) {
        this.kUp = kUp;
        this.kDown = kDown;
        this.kLeft = kLeft;
        this.kRight = kRight;
        this.xAxis = 0.0;
        this.yAxis = 0.0;
        this.ks = KeyboardState.getInstance();
    }

    public void update() {
        this.xAxis = (ks.getKey(kLeft) && !ks.getKey(kRight)) ? 1 : (ks.getKey(kRight) && !ks.getKey(kLeft)) ? -1 : 0;
        this.yAxis = (ks.getKey(kUp) && !ks.getKey(kDown)) ? 1 : (ks.getKey(kDown) && !ks.getKey(kUp)) ? -1 : 0;
    }

    public double getXAxis() {
        return xAxis;
    }

    public double getYAxis() {
        return yAxis;
    }
}
