package dev.game.actors.characters;

import dev.game.mechanics.Damage;
import dev.game.mechanics.Damageable;
import dev.game.mechanics.action.ActionPreview;

import java.awt.*;

public abstract class Champion implements Damageable {
    private int health;
    private int physArmour;
    private int energyArmour;

    public Champion(int health, int physArmour, int energyArmour) {
        this.health = health;
        this.physArmour = physArmour;
        this.energyArmour = energyArmour;
    }

    public abstract Image getIcon();

    public abstract int getNumSkills();

    public abstract ActionPreview previewSkill(int skill);

    public abstract void castSkill(int skill);

    public void damage(Damage damage) {
        this.health = this.health - damage.calcDamage(physArmour, energyArmour);
    }

}
