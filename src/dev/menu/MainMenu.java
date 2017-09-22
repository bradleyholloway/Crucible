package dev.menu;

import dev.input.GameInput;
import dev.manager.GameWindow;
import dev.util.Config;

import java.awt.*;

public class MainMenu extends GenericMenu {

    public MainMenu() {
        super();
        Font mainMenuFont = new Font("Monospaced", Font.PLAIN, 40);
        MenuTextElement startGame = new MenuTextElement(new Point(200,300),MenuReturnCode.MAIN_LAUNCH_INSTANCE, "Start Game", mainMenuFont);
        MenuTextElement options = new MenuTextElement(new Point(250,450), MenuReturnCode.MAIN_OPTIONS, Config.getInstance().getString("optionsMenuText","Options"), mainMenuFont);
        MenuTextElement quit = new MenuTextElement(new Point(300,600),MenuReturnCode.MAIN_QUIT, "Quit Game", mainMenuFont);
        //Linking
        startGame.setUpElement(quit);
        startGame.setDownElement(options);
        options.setUpElement(startGame);
        options.setDownElement(quit);
        quit.setUpElement(options);
        quit.setDownElement(startGame);

        addDefaultElement(startGame);
        addMenuElement(options);
        addMenuElement(quit);
    }

    @Override
    void drawMenu(GameWindow gw) {
        gw.graphics.setColor(Color.WHITE);
        super.drawMenu(gw);
    }

    @Override
    void drawActiveElement(GameWindow gw, MenuElement e) {
        gw.graphics.setColor(Color.BLUE);
        e.draw(gw);
    }
}
