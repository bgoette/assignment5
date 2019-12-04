package main.java.patterns.factory;

import main.java.BaseCharacter;

public abstract class BaseVillain extends BaseCharacter {

    /**
     * Default constructor.
     * @param maxDamage The max damage this villain can take.
     * @param description The description of this villain.
     */
    public BaseVillain(int maxDamage, String description) {
        super(maxDamage, description);
        
        this.powerLevel = 1;
    }
}
