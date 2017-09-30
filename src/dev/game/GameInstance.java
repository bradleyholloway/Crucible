package dev.game;

import dev.game.actors.Player;
import dev.game.actors.characters.BobLee;
import dev.game.map.Map;
import dev.game.map.MapRelationManager;
import dev.game.map.NextSelectedCallback;
import dev.game.map.Tile;
import dev.game.mechanics.Faction;
import dev.game.mechanics.TimeManager;
import dev.input.GameInput;
import dev.manager.GameWindow;

public class GameInstance {
    private Map map;
    private TimeManager timeManager;
    private CameraFocus camera;
    private Player player;


    public GameInstance() {
        map = new Map();
        camera = new CameraFocus(0,0);
        timeManager = new TimeManager();
        player = new Player(new BobLee(), Faction.Blue);
        player.moveTo(map.getTile(0, 0));
    }

    public void update(GameWindow gw, GameInput gi) {
        camera.move(gi.cameraJoystick().getXAxis() * 8, gi.cameraJoystick().getYAxis() * 8);

        map.update(gw, camera, gi);
        timeManager.draw(gw);

        if (map.currentlySelected() != null) {
            if (player.equals(map.currentlySelected().getMapItem())) {
                map.setNextSelectedCallback(tile -> {
                    MapRelationManager mr = new MapRelationManager(player.location(), tile);
                    if (mr.isAdjacent()) {
                        player.moveTo(tile);
                    }
                });
            }
        }
    }
}
