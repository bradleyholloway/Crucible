package dev.game.actors;

import dev.game.CameraFocus;
import dev.game.map.MapItem;
import dev.game.map.Tile;
import dev.game.mechanics.Faction;
import dev.manager.GameWindow;

import java.awt.*;

public abstract class NeutralEnemy extends Actor{
    public NeutralEnemy() {
        super(Faction.Neutral);
    }

    @Override
    public boolean isTargetable(Faction byFaction) {
        return (byFaction!=Faction.Neutral);
    }
}
