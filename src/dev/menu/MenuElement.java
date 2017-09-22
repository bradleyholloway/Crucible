package dev.menu;

import dev.manager.GameWindow;

import java.awt.*;

public abstract class MenuElement {

    private Point location;
    private MenuReturnCode returnCode;

    private MenuElement upElement;
    private MenuElement downElement;
    private MenuElement rightElement;
    private MenuElement leftElement;

    public MenuElement(Point location, MenuReturnCode returnCode) {
        this.location = location;
        this.returnCode = returnCode;

        upElement = downElement = rightElement = leftElement = null;
    }

    public void setUpElement(MenuElement upElement) {
        this.upElement = upElement;
    }

    public void setDownElement(MenuElement downElement) {
        this.downElement = downElement;
    }

    public void setLeftElement(MenuElement leftElement) {
        this.leftElement = leftElement;
    }

    public void setRightElement(MenuElement rightElement) {
        this.rightElement = rightElement;
    }

    public Point getLocation() {
        return location;
    }

    public Point getScaledLocation(GameWindow gw) {
        return new Point(gw.getWidth() * location.x / 1000, gw.getHeight() * location.y / 1000);
    }

    public MenuReturnCode getReturnCode() {
        return returnCode;
    }

    public MenuElement getUpElement() {
        return upElement;
    }

    public MenuElement getDownElement() {
        return downElement;
    }

    public MenuElement getRightElement() {
        return rightElement;
    }

    public MenuElement getLeftElement() {
        return leftElement;
    }

    public abstract void draw(GameWindow gw);
}
