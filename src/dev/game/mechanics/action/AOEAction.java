package dev.game.mechanics.action;

public interface AOEAction extends Action {
    boolean lineOfSight();
    double radius();
}
