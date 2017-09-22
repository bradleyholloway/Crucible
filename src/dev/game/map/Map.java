package dev.game.map;

import dev.game.CameraFocus;
import dev.input.GameInput;
import dev.manager.GameWindow;

import java.awt.*;

public class Map {
    public final int MAP_WIDTH = 50;
    public final int MAP_HEIGHT = (int) Math.ceil(Math.sqrt(3) / 2 * MAP_WIDTH);
    private Tile[][] grid;

    private int sideLength = 50;
    private Rectangle screen;

    private Tile previousSelected;

    public Map() {
        grid = new Tile[MAP_WIDTH][MAP_HEIGHT];
        Tile.setSideLength(sideLength);
        for (int i = 0; i < MAP_WIDTH; i++) {
            for (int j = 0; j < MAP_HEIGHT; j++) {
                grid[i][j] = new Tile(i, j);
            }
        }
        previousSelected = null;
    }

    public void update(GameWindow gw, CameraFocus cam, GameInput gi) {
        screen = new Rectangle(gw.getWidth(), gw.getHeight());
        updateGrid(gw, cam);
        adjustTileStates(gw, cam, gi);

        drawGrid(gw, cam);
        if (previousSelected != null) {
            previousSelected.draw(gw, cam, screen);
        }
    }

    private void adjustTileStates(GameWindow gw, CameraFocus cam, GameInput gi) {
        Tile underCursor = getTileUnderCursor(gw, cam, gi);
        if (underCursor != null) {
            if (gi.focusSelect()) {
                if (previousSelected != null) {
                    previousSelected.clear();
                }
                previousSelected = underCursor;
                underCursor.select();
            } else {
                underCursor.hover();
            }
        }
    }

    private Tile getTileUnderCursor(GameWindow gw, CameraFocus cam, GameInput gi) {
        for (int i = 0; i < MAP_WIDTH; i++) {
            for (int j = 0; j < MAP_HEIGHT; j++) {
                if (grid[i][j].contains(gi.focusPoint())) {
                    return grid[i][j];
                }
            }
        }
        return null;
    }

    private void updateGrid(GameWindow gw, CameraFocus cam) {
        for (int i = 0; i < MAP_WIDTH; i++) {
            for (int j = 0; j < MAP_HEIGHT; j++) {
                grid[i][j].update(gw, cam, screen);
            }
        }
    }


    private void drawGrid(GameWindow gw, CameraFocus cam) {
        for (int i = 0; i < MAP_WIDTH; i++) {
            for (int j = 0; j < MAP_HEIGHT; j++) {
                grid[i][j].draw(gw, cam, screen);
            }
        }
    }
}
