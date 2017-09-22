package dev.manager;

import dev.game.GameInstance;
import dev.input.GameInput;
import dev.input.controls.KeyboardMouse;
import dev.menu.MainMenu;
import dev.menu.MenuReturnCode;

import java.awt.*;
import java.awt.event.WindowEvent;

import static dev.manager.GameState.*;

public class GameEngine {
    private final boolean SHOW_FRAME_STATISTICS = true;
    private long lastFrame;

    private GameState gs;
    private MainMenu mainMenu;
    private GameInstance gameInstance;
    private GameInput gameInput;

    public GameEngine() {
        gs = Initializing;

        gameInstance = new GameInstance();
        mainMenu = new MainMenu();
        gameInput = new GameInput(new KeyboardMouse());
    }

    public void update(GameWindow gw) {
        if (SHOW_FRAME_STATISTICS) {
            long now = System.currentTimeMillis();
            long diff = now - lastFrame;
            double seconds = (double) diff / 1000;
            double fps = 1 / seconds;

            gw.graphics.setFont(new Font("TimesRoman", Font.PLAIN, 12));
            gw.graphics.setColor(Color.WHITE);
            String output = String.format("Millis: %d        FPS: %d", diff, Math.round(fps));
            gw.graphics.drawString(output, 200, 200);
            lastFrame = now;
        }

        gameInput.update();

        switch (gs) {
            case Initializing:
                gs = GameState.MainMenu;
                break;
            case MainMenu:
                MenuReturnCode mainMenuVal = mainMenu.update(gw, gameInput);
                switch (mainMenuVal) {
                    case MAIN_LAUNCH_INSTANCE:
                        gs = GameState.InGame;
                        break;
                    case MAIN_OPTIONS:
                        break;
                    case MAIN_QUIT:
                        gw.dispatchEvent(new WindowEvent(gw, WindowEvent.WINDOW_CLOSING));
                        break;
                }
                break;
            case InGame:
                gameInstance.update(gw, gameInput);

                if (gameInput.menuNavigationBack()) {
                    gs = GameState.MainMenu;
                }
                break;
        }
    }
}
