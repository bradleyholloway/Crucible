package dev.input;

import dev.input.util.ControlButton;
import dev.input.util.VirtualJoystick;

import java.awt.*;

public class GameInput implements GameInputMapping{
    private GameInputMapping map;
    // Menu Navigation
    private ControlButton menuNavigationUp;
    private ControlButton menuNavigationDown;
    private ControlButton menuNavigationLeft;
    private ControlButton menuNavigationRight;
    private ControlButton menuNavigationEnter;
    private ControlButton menuNavigationBack;
    // Focus Control
    private ControlButton focusClick;
    private ControlButton focusAltClick;

    public GameInput(GameInputMapping map) {
        this.map = map;

        // Menu Navigation
        menuNavigationUp = new ControlButton();
        menuNavigationDown = new ControlButton();
        menuNavigationLeft = new ControlButton();
        menuNavigationRight = new ControlButton();
        menuNavigationEnter = new ControlButton();
        menuNavigationBack = new ControlButton();

        // Focus Control
        focusClick = new ControlButton();
        focusAltClick = new ControlButton();
    }

    public void update() {
        menuNavigationUp.update(map.menuNavigationUp());
        menuNavigationDown.update(map.menuNavigationDown());
        menuNavigationLeft.update(map.menuNavigationLeft());
        menuNavigationRight.update(map.menuNavigationRight());
        menuNavigationEnter.update(map.menuNavigationEnter());
        menuNavigationBack.update(map.menuNavigationBack());
        map.cameraJoystick().update();
        focusClick.update(map.focusSelect());
        focusAltClick.update(map.focusAltSelect());
    }

    @Override
    public boolean menuNavigationUp() {
        return menuNavigationUp.getState();
    }

    @Override
    public boolean menuNavigationDown() {
        return menuNavigationDown.getState();
    }

    @Override
    public boolean menuNavigationLeft() {
        return menuNavigationLeft.getState();
    }

    @Override
    public boolean menuNavigationRight() {
        return menuNavigationRight.getState();
    }

    @Override
    public boolean menuNavigationEnter() {
        return menuNavigationEnter.getState();
    }

    @Override
    public boolean menuNavigationBack() {
        return menuNavigationBack.getState();
    }

    @Override
    public VirtualJoystick cameraJoystick() {
        return map.cameraJoystick();
    }

    @Override
    public Point focusPoint() {
        return map.focusPoint();
    }

    @Override
    public boolean focusSelect() {
        return focusClick.getState();
    }

    @Override
    public boolean focusAltSelect() {
        return focusAltClick.getState();
    }
}
