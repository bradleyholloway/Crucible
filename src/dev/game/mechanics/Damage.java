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
    public int calcDamage(double physArmour, double energyArmour) {
        int physComponent = (int) (physicalDamage / (Math.max(physArmour-physicalPenetration, 1)));
        int energyComponent = (int) (energyDamage / (Math.max(energyArmour-energyPenetration, 1)));
        return physComponent + energyComponent;
    }
}
