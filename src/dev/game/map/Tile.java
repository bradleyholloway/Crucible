package dev.game.map;

import dev.game.CameraFocus;
import dev.manager.GameWindow;

import java.awt.*;

public class Tile {
    private static int sideLength;

    private int i;
    private int j;
    private Point center;

    private boolean currentlySelected;
    private boolean hovered;

    private MapItem mapItem;
    private Polygon hex;

    public Tile(int i, int j) {
        this.i = i;
        this.j = j;
        this.currentlySelected = false;
        mapItem = null;
    }

    public static void setSideLength(int sl) {
        sideLength = sl;
    }

    public void update(GameWindow gw, CameraFocus cam, Rectangle onScreen) {
        boolean offset = j % 2 == 1;
        center = new Point(
                (int) (i * Math.sqrt(3) * sideLength + cam.getX() + ((offset) ? sideLength * Math.sqrt(3) / 2 : 0)),
                (int) (j * sideLength * 1.5) + cam.getY());
        hex = makeHexagon();

    }

    public boolean contains(Point p) {
        return hex.contains(p);
    }

    public void draw(GameWindow gw, CameraFocus cam, Rectangle onScreen) {
        if (onScreen(onScreen)) {
            if (currentlySelected) {
                gw.graphics.setColor(Color.RED);
                if (mapItem != null) {
                    mapItem.drawInfo(gw);
                }
            } else if (hovered) {
                gw.graphics.setColor(Color.BLUE);
                hovered = false;
            } else {
                gw.graphics.setColor(Color.WHITE);
            }

            gw.graphics.drawPolygon(hex);

            if (this.mapItem != null) {
                this.mapItem.draw(gw, cam, center);
            }

        }
    }


    public boolean onScreen(Rectangle screen) {
        return hex.intersects(screen);
    }

    public Point getLocation() {
        return new Point(i, j);
    }

    public void hover() {
        this.hovered = true;
    }

    public void select() {
        this.currentlySelected = true;
    }

    public void clear() {
        this.currentlySelected = false;
    }

    public void setMapItem(MapItem item) {
        this.mapItem = item;
    }

    public MapItem getMapItem() {
        return this.mapItem;
    }

    private Polygon makeHexagon() {
        Polygon hexagon = new Polygon();
        for (double ang = 0; ang < 2 * Math.PI; ang += Math.PI / 3) {
            Point p = getPoint(center.x, center.y, ang);
            hexagon.addPoint(p.x, p.y);
        }
        return hexagon;
    }

    private Point getPoint(int x, int y, double angle) {
        double cX = x + sideLength * Math.sin(angle);
        double cY = y + sideLength * Math.cos(angle);
        return new Point((int) cX, (int) cY);
    }
}
