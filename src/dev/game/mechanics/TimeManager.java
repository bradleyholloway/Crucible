package dev.game.mechanics;

import dev.game.map.MapItem;
import dev.manager.GameWindow;

import java.awt.*;

public class TimeManager {
    private final Rectangle SCREEN_LOCATION = new Rectangle(700,0,300,100);

    public void draw(GameWindow gw) {
        Rectangle scaledArea = new Rectangle();
        scaledArea.x = SCREEN_LOCATION.x * gw.getWidth() / 1000;
        scaledArea.width = SCREEN_LOCATION.width * gw.getWidth() / 1000;
        scaledArea.y = SCREEN_LOCATION.y * gw.getHeight() / 1000;
        scaledArea.height = SCREEN_LOCATION.height * gw.getHeight() / 1000;

        gw.graphics.setColor(Color.ORANGE);
        gw.graphics.fillRoundRect(scaledArea.x, scaledArea.y, scaledArea.width, scaledArea.height,10,10);
    }
}
