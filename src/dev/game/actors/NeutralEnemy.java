package dev.game.actors;

import dev.game.CameraFocus;
import dev.game.map.MapItem;
import dev.game.map.Tile;
import dev.game.mechanics.Faction;
import dev.manager.GameWindow;

public class NeutralEnemy implements MapItem {
    @Override
    public void update(GameWindow gw, CameraFocus cam) {

    }

    @Override
    public boolean isTargetable(Faction byFaction) {
        return (byFaction!=Faction.Neutral);
    }

    @Override
    public boolean blocksLineOfSight() {
        return false;
    }

    @Override
    public Tile location() {
        return null;
    }
}
