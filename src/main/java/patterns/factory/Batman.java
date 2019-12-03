package main.java.patterns.factory;

import main.java.patterns.decorator.ISuperPower;

/**
 * Batman hero.
 * 
 * @author bagoette
 *
 */
public class Batman extends BaseHero {

    /**
     * Default constructor.
     */
    public Batman() {
        super(10);

        this.description = "Batman";
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
            this.log("[ATTACK] Why am I human! 0 damage inflicted.");

            return 0;
        }
    }
}
