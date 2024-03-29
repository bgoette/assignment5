package main.java.patterns.factory;

import main.java.patterns.decorator.ISuperPower;
import main.java.patterns.decorator.SuperHearingDecorator;

/**
 * Iron Man hero.
 * 
 * @author bagoette
 *
 */
public class IronMan extends BaseHero {

    /**
     * Default constructor.
     */
    public IronMan() {
        super(12, "Iron Man");
        
        this.superPowers.add(new SuperHearingDecorator(10));
    }

    @Override
    public int attack() {
        if (this.ticksLeftToHeal > 0) {
            return 0;
        }
        
        if (this.superPowers.size() > 0) {
            ISuperPower power = this.superPowers.get(randy.nextInt(this.superPowers.size()));
            int damage = (int) ((double) power.getDamageStrength() * (double) this.powerLevel
                    * 0.6);

            this.log("[ATTACK] " + power.attack() + " " + damage + " damage inflicted!");

            return damage;
        } else {
            this.log("[ATTACK] Where are you, Jarvis?! 0 damage inflicted");

            return 0;
        }
    }
}
