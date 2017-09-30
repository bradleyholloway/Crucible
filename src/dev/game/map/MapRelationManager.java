package dev.game.map;

import java.awt.*;

public class MapRelationManager {
    private Tile origin;
    private Tile target;

    public MapRelationManager(Tile origin, TileRelation relation) {
        this.origin = origin;
        this.target = relation.from(origin);
    }
    public MapRelationManager(Tile origin, Tile target) {
        this.origin = origin;
        this.target = target;
    }

    public boolean isAdjacent() {
        Point o = origin.getLocation();
        Point t = target.getLocation();
        if (o.x == t.x && Math.abs(o.y - t.y) == 1) {
            return true;
        }
        if (o.y == t.y && Math.abs(o.x - t.x) == 1) {
            return true;
        }
        boolean offset = o.y % 2 == 1;
        if (!offset) {
            if (o.y == t.y +1 && o.x == t.x + 1) {
                return true;
            }
            if (o.y == t.y - 1 && o.x == t.x + 1) {
                return true;
            }
        } else if (offset) {
            if (o.y == t.y - 1 && o.x - t.x == -1) {
                return true;
            }
            if (o.y == t.y + 1 && o.x - t.x == -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isVisible() {
        return true;
    }
}
