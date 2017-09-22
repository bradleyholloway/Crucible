package dev.game.mechanics.action;

import dev.game.actors.Actor;
import dev.game.map.Tile;

import java.util.Collection;

public class ActionPreview {
    private Action action;
    private Actor actor;

    public ActionPreview(Action action, Actor actor) {

    }

    public Collection<Tile> potentialTiles() {
        return null;
    }
}
