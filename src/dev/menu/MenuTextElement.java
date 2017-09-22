package dev.menu;

import dev.manager.GameWindow;

import java.awt.*;

public class MenuTextElement extends MenuElement {
    private String text;
    private Font font;

    public MenuTextElement(Point location, MenuReturnCode returnCode, String text) {
        super(location, returnCode);
        this.text = text;
        this.font = null;
    }

    public MenuTextElement(Point location, MenuReturnCode returnCode, String text, Font font) {
        super(location, returnCode);
        this.text = text;
        this.font = font;
    }

    @Override
    public void draw(GameWindow gw) {
        if (font != null) {
            gw.graphics.setFont(font);
        }
        gw.graphics.drawString(text, getScaledLocation(gw).x, getScaledLocation(gw).y);
    }
}
