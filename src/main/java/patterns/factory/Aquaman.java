package main.java.patterns.factory;

import main.java.patterns.decorator.ISuperPower;
import main.java.patterns.decorator.XRayDecorator;

public class Aquaman extends BaseHero {

    public Aquaman() {
        super(15, "Aqua Man");

        this.superPowers.add(new XRayDecorator());
    }

    @Override
    public int attack() {
        if (this.superPowers.size() > 0) {
            ISuperPower power = this.superPowers.get(randy.nextInt(this.superPowers.size()));
            int damage = (int) ((double) power.getDamageStrength() * (double) this.powerLevel
                    * 0.5);

            this.log("[ATTACK] " + power.attack() + " " + damage + " damage inflicted!");

            return damage;
        } else {
            this.log("[ATTACK] Not sure if I can really breath down here... 0 damage inflicted.");

            return 0;
        }
    }
}
