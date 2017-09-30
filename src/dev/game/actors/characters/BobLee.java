package dev.game.actors.characters;

import dev.game.map.Map;
import dev.game.mechanics.action.ActionPreview;
import dev.util.Config;

import java.awt.*;
import java.awt.image.BufferedImage;



public class BobLee extends Champion{
    private static int i_health = Config.getInstance().get("c_boblee_health", 100);
    private static int i_physArmour = Config.getInstance().get("c_boblee_physArmour", 5);
    private static int i_energyArmour = Config.getInstance().get("c_boblee_energyArmour", 5);

    public BobLee() {
        super(i_health, i_physArmour, i_energyArmour);
    }

    @Override
    public Image getIcon() {
        BufferedImage bobIcon = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bobIcon.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.fillOval(0,0,bobIcon.getWidth(),bobIcon.getHeight());
        return bobIcon;
    }

    @Override
    public int getNumSkills() {
        return 0;
    }

    @Override
    public ActionPreview previewSkill(int skill) {
        return null;
    }

    @Override
    public void castSkill(int skill) {

    }

}
