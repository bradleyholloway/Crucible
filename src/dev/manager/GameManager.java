package dev.manager;

import dev.menu.MainMenu;
import dev.util.Config;

public class GameManager {
    private GameWindow gw;
    private GameEngine ge;
    private FrameManager fm;

    private int targetFrameRate;
    private long targetMillis;
    private long startFrameTime;

    private GameManager() {
        gw = new GameWindow();
        ge = new GameEngine();
        fm = new FrameManager();

        targetFrameRate = Config.getInstance().get("frameRate", 60);
        fm.start();
    }

    public static void start() {
        new GameManager();
    }

    private class FrameManager extends Thread {
        private boolean shouldStop = false;
        public void run() {
            targetMillis = 1000/targetFrameRate;
            while (!shouldStop) {
                try {
                    Thread.sleep(Math.max(targetMillis - (System.currentTimeMillis() - startFrameTime), 0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startFrameTime = System.currentTimeMillis();
                ge.update(gw);
                gw.update();
            }
        }

        public void signalStop() {
            shouldStop = true;
        }
    }
}
