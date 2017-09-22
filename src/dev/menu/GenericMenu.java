package dev.menu;

import dev.input.GameInput;
import dev.manager.GameWindow;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericMenu {
    private List<MenuElement> menuElements;
    private MenuElement activeElement;

    public GenericMenu() {
        menuElements = new ArrayList<>();
    }

    public void addMenuElement(MenuElement e) {
        menuElements.add(e);
    }

    public void addDefaultElement(MenuElement e) {
        menuElements.add(e);
        activeElement = e;
    }

    public MenuReturnCode update(GameWindow gw, GameInput gi) {
        drawMenu(gw);

        if (gi.menuNavigationEnter()) {
            return activeElement.getReturnCode();
        } else if (gi.menuNavigationBack()) {
            return MenuReturnCode.MENU_BACK;
        } else if (gi.menuNavigationUp()) {
            if (activeElement.getUpElement() != null)
                activeElement = activeElement.getUpElement();
        } else if (gi.menuNavigationDown()) {
            if (activeElement.getDownElement() != null)
                activeElement = activeElement.getDownElement();
        } else if (gi.menuNavigationLeft()) {
            if (activeElement.getLeftElement() != null)
                activeElement = activeElement.getLeftElement();
        } else if (gi.menuNavigationRight()) {
            if (activeElement.getRightElement() != null)
                activeElement = activeElement.getRightElement();
        }
        return MenuReturnCode.NO_ACTION;
    }

    void drawMenu(GameWindow gw) {
        for (MenuElement e : menuElements) {
            if (e != activeElement)
                e.draw(gw);
        }
        drawActiveElement(gw, activeElement);
    }

    abstract void drawActiveElement(GameWindow gw, MenuElement e);
}
