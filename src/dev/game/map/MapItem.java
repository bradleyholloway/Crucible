package dev.game.map;

import dev.game.CameraFocus;
import dev.game.mechanics.Faction;
import dev.manager.GameWindow;

public interface MapItem {
    void update(GameWindow gw, CameraFocus cam);
    boolean isTargetable(Faction byFaction);
    boolean blocksLineOfSight();
    Tile location();
}
