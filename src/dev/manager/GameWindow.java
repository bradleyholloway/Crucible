package dev.manager;

import dev.input.util.KeyboardState;
import dev.input.util.MouseState;
import dev.util.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame{
    public final Graphics graphics;
    private BufferedImage buffer;
    private Graphics frameGraphics;

    public GameWindow() {
        super(Config.getInstance().getString("windowTitle", "DefualtTitle"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        pack();
        setVisible(true);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graphics = buffer.getGraphics();
        frameGraphics = getGraphics();

        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher(KeyboardState.getInstance());
        addMouseListener(MouseState.getInstance());
    }

    public void update() {
        frameGraphics.drawImage(buffer,0,0, null);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, getWidth(), getHeight());
    }


}
