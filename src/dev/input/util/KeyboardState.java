package dev.input.util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class KeyboardState implements KeyEventDispatcher{
    private static KeyboardState instance;
    private boolean[] keys;
    private KeyboardState() {
        keys = new boolean[256];
        Arrays.fill(keys, false);
    }

    public static KeyboardState getInstance() {
        return (instance == null) ? instance = new KeyboardState() : instance;
    }

    public boolean getKey(int keyCode) {
        return keys[keyCode];
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        switch (e.getID()) {
            case KeyEvent.KEY_PRESSED:
                if (e.getKeyCode() < 256) {
                    keys[e.getKeyCode()] = true;
                }
                break;
            case KeyEvent.KEY_RELEASED:
                if (e.getKeyCode() < 256) {
                    keys[e.getKeyCode()] = false;
                }
                break;
        }
        return false;
    }
}
