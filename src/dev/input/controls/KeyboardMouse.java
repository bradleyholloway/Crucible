package dev.input.controls;

import dev.input.GameInputMapping;
import dev.input.util.KeyboardState;
import dev.input.util.MouseState;
import dev.input.util.VirtualJoystick;

import java.awt.*;

public class KeyboardMouse implements GameInputMapping {
    private KeyboardState ks = KeyboardState.getInstance();
    private MouseState ms = MouseState.getInstance();
    private VirtualJoystick cameraJoystick = new VirtualJoystick(87,83,65,68);

    @Override
    public boolean menuNavigationUp() {
        // 'W' = 87 UP =38
        return ks.getKey(87)|| ks.getKey(38);
    }

    @Override
    public boolean menuNavigationDown() {
        // 'S' = 83 Down 40
        return ks.getKey(83)|| ks.getKey(40);
    }

    @Override
    public boolean menuNavigationLeft() {
        // 'A' = 65 Left 37
        return ks.getKey(65)|| ks.getKey(37);
    }

    @Override
    public boolean menuNavigationRight() {
        // 'D' = 68 Right 39
        return ks.getKey(68)|| ks.getKey(39);
    }

    @Override
    public boolean menuNavigationEnter() {
        // Enter = 13, Space = 32
        return ks.getKey(10) || ks.getKey(32);
    }

    @Override
    public boolean menuNavigationBack() {
        // Escape = 27
        return ks.getKey(27);
    }

    @Override
    public VirtualJoystick cameraJoystick() {
        return cameraJoystick;
    }

    @Override
    public Point focusPoint() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    @Override
    public boolean focusSelect() {
        return ms.getLeftMouse();
    }

    @Override
    public boolean focusAltSelect() {
        return ms.getRightMouse();
    }
}
