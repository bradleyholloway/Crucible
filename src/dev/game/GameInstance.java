package dev.game;

import dev.game.map.Map;
import dev.input.GameInput;
import dev.manager.GameWindow;

public class GameInstance {
    private Map map;
    private CameraFocus camera;


    public GameInstance() {
        map = new Map();
        camera = new CameraFocus(0,0);
    }

    public void update(GameWindow gw, GameInput gi) {
        camera.move(gi.cameraJoystick().getXAxis() * 8, gi.cameraJoystick().getYAxis() * 8);

        map.update(gw, camera, gi);

    }
}
