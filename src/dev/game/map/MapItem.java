package dev.game.map;

import dev.game.CameraFocus;
import dev.game.mechanics.Faction;
import dev.manager.GameWindow;

import java.awt.*;

public interface MapItem {
    final Rectangle INFO_AREA = new Rectangle(0,0,300,100);

    void update(GameWindow gw, CameraFocus cam);
    void draw(GameWindow gw, CameraFocus cam, Point center);
    void drawInfo(GameWindow gw);
    boolean isTargetable(Faction byFaction);
    boolean blocksLineOfSight();
    Tile location();
}
