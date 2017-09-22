package dev.input.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseState implements MouseListener {
    private static MouseState instance;

    boolean leftClick = false;
    boolean rightClick = false;

    public static MouseState getInstance() {
        return (instance == null) ?  instance = new MouseState() : instance;
    }

    private MouseState() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public boolean getLeftMouse() {
        return leftClick;
    }

    public boolean getRightMouse() {
        return rightClick;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1:
                leftClick = true;
                break;
            case MouseEvent.BUTTON2:
                rightClick = true;
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1:
                leftClick = false;
                break;
            case MouseEvent.BUTTON2:
                rightClick = false;
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
