package dev.game.actors;

import dev.game.CameraFocus;
import dev.game.actors.characters.Champion;
import dev.game.map.MapItem;
import dev.game.map.Tile;
import dev.game.mechanics.Faction;
import dev.manager.GameWindow;

import java.awt.*;

public class Player extends Actor{
    private Champion champion;

    public Player(Champion champion, Faction faction) {
        super(faction);
        this.champion = champion;
    }

    @Override
    public void update(GameWindow gw, CameraFocus cam) {

    }

    @Override
    public void draw(GameWindow gw, CameraFocus cam, Point center) {
        Image champIcon = champion.getIcon();
        int sideLength = champIcon.getWidth(null)/2;
        gw.graphics.drawImage(champIcon, center.x-sideLength, center.y - sideLength, null);
    }

    @Override
    public void drawInfo(GameWindow gw) {
        Rectangle scaledArea = new Rectangle();
        scaledArea.x = MapItem.INFO_AREA.x * gw.getWidth() / 1000;
        scaledArea.width = MapItem.INFO_AREA.width * gw.getWidth() / 1000;
        scaledArea.y = MapItem.INFO_AREA.y * gw.getHeight() / 1000;
        scaledArea.height = MapItem.INFO_AREA.height * gw.getHeight() / 1000;

        gw.graphics.setColor(Color.YELLOW);
        gw.graphics.fillRoundRect(scaledArea.x, scaledArea.y, scaledArea.width, scaledArea.height,10,10);
    }
}
