package main.java.patterns.factory;

import main.java.patterns.decorator.ISuperPower;

/**
 * Superman hero
 * @author bagoette
 *
 */
public class Superman extends BaseHero {

    /**
     * Default constructor
     */
    public Superman() {
        
        // Takes very little damage
        super(5);
        
        this.description = "Superman";
    }

    @Override
    public int attack() {
        if (this.superPowers.size() > 0) {
            ISuperPower power = this.superPowers.get(randy.nextInt(this.superPowers.size()));
            int damage = (int) ((double) power.getDamageStrength() * (double) this.powerLevel * 0.5);
            
            this.log("[ATTACK] " + power.attack() + " " + damage + " damage inflicted!");

            return damage;
        } else {
            this.log("[ATTACK] This Kryptonite...sucks! 0 damage inflicted.");
            
            return 0;
        }
    }
}
