package main.java.patterns.factory;

import main.java.patterns.decorator.ISuperPower;
import main.java.patterns.decorator.LaserBeamDecorator;

/**
 * Superman hero.
 * 
 * @author bagoette
 *
 */
public class Superman extends BaseHero {

    /**
     * Default constructor.
     */
    public Superman() {

        // Takes very little damage, String description) {
        super(5, "Superman");
        
        superPowers.add(new LaserBeamDecorator(20));
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
            this.log("[ATTACK] This Kryptonite...sucks! 0 damage inflicted.");

            return 0;
        }
    }
}
