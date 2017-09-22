package dev.game.mechanics;

public class Damage {
    double energyDamage;
    double physicalDamage;
    double energyPenetration;
    double physicalPenetration;

    public Damage(double physicalDamage, double physicalPenetration, double energyDamage, double energyPenetration) {
        this.energyDamage = energyDamage;
        this.physicalDamage = physicalDamage;
        this.energyPenetration = energyPenetration;
        this.physicalPenetration = physicalPenetration;
    }
}
