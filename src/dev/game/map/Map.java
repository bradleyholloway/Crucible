package dev.game.map;

import dev.game.CameraFocus;
import dev.input.GameInput;
import dev.manager.GameWindow;

import java.awt.*;

public class Map {
    public final int MAP_WIDTH = 50;
    public final int MAP_HEIGHT = (int) Math.ceil(Math.sqrt(3) / 2 * MAP_WIDTH);
    public final Rectangle SAFE_AREA = new Rectangle(0,150,1000,700);
    private Tile[][] grid;
    private NextSelectedCallback nextSelectedCallback = null;

    private int sideLength = 35;
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
        updateScreen(gw);

        updateGrid(gw, cam);
        adjustTileStates(gw, cam, gi);

        drawGrid(gw, cam);
        if (previousSelected != null) {
            previousSelected.draw(gw, cam, screen);
        }
    }

    public void setNextSelectedCallback(NextSelectedCallback callback) {
        this.nextSelectedCallback = callback;
    }

    public Tile getTile(int i, int j) {
        return grid[i][j];
    }

    public Tile currentlySelected() {
        return previousSelected;
    }

    private void updateScreen(GameWindow gw) {
        screen = new Rectangle();
        screen.x = (int) (SAFE_AREA.x * gw.getWidth() / 1000);
        screen.y = (int) (SAFE_AREA.y * gw.getHeight() / 1000);
        screen.width = (int) (SAFE_AREA.width * gw.getWidth() / 1000);
        screen.height = (int) (SAFE_AREA.height * gw.getHeight() / 1000);
    }

    private void adjustTileStates(GameWindow gw, CameraFocus cam, GameInput gi) {
        Tile underCursor = getTileUnderCursor(gw, cam, gi);

        if (gi.focusSelect()) {
            if (previousSelected != null) {
                previousSelected.clear();
            }
            previousSelected = underCursor;
            if (underCursor != null) {
                underCursor.select();
                if (nextSelectedCallback != null) {
                    nextSelectedCallback.newTileSelected(underCursor);
                }
            }
            nextSelectedCallback = null;
        } else if (underCursor != null) {
            underCursor.hover();
        }

    }



    private Tile getTileUnderCursor(GameWindow gw, CameraFocus cam, GameInput gi) {
        for (int i = 0; i < MAP_WIDTH; i++) {
            for (int j = 0; j < MAP_HEIGHT; j++) {
                if (grid[i][j].onScreen(screen) && grid[i][j].contains(gi.focusPoint())) {
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

    private int getSideLength() {
        return this.sideLength;
    }
}
