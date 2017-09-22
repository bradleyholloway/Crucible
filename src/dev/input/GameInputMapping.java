package dev.input;

import dev.input.util.VirtualJoystick;

import java.awt.*;

public interface GameInputMapping {
    // Menu navigation
    boolean menuNavigationUp();
    boolean menuNavigationDown();
    boolean menuNavigationLeft();
    boolean menuNavigationRight();
    boolean menuNavigationEnter();
    boolean menuNavigationBack();
    // Camera control
    VirtualJoystick cameraJoystick();
    // Focus Point (Mouse)
    Point focusPoint();
    boolean focusSelect();
    boolean focusAltSelect();

}
