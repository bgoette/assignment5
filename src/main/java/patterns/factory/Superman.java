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
    }

    @Override
    public int attack() {
        if (this.superPowers.size() > 0) {
            ISuperPower power = this.superPowers.get(randy.nextInt(this.superPowers.size()));
            this.log(power.attack());
            
            return (int)(
                    (double)power.getDamageStrength() * 
                    (double)this.powerLevel * 
                    (double)(1.0 / 4.0));
        } else {
            this.log("This Kryptonite...sucks!");
            
            return 0;
        }
    }
}
