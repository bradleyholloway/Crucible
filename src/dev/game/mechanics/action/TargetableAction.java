package dev.game.mechanics.action;

import dev.game.map.TileRelation;

import java.util.Collection;

public interface TargetableAction extends Action{
    boolean lineOfSight();
    Collection<TileRelation> possibleTargets();
}
