package dev.game.actors;

import dev.game.map.MapItem;
import dev.game.map.Tile;
import dev.game.mechanics.Faction;

import java.awt.*;

public abstract class Actor implements MapItem {
    private Tile location;
    private Faction faction;

    public Actor(Faction faction) {
        this.faction = faction;
    }

    @Override
    public Tile location() {
        return this.location;
    }

    @Override
    public boolean isTargetable(Faction faction) {
        return this.faction != faction;
    }

    @Override
    public boolean blocksLineOfSight() {
        return false;
    }

    public void moveTo(Tile newLocation) {
        if (this.location != null) {
            location.setMapItem(null);
        }
        this.location = newLocation;
        if (this.location != null) {
            location.setMapItem(this);
        }
    }
}
