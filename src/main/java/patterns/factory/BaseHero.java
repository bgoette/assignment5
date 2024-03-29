package main.java.patterns.factory;

import main.java.BaseCharacter;

public abstract class BaseHero extends BaseCharacter {

    protected int civiliansSaved;

    /**
     * Default constructor.
     * @param maxDamage The max this character can take in damage.
     */
    public BaseHero(int maxDamage, String description) {
        super(maxDamage, description);

        this.civiliansSaved = 0;
        this.powerLevel = 1;
    }

    /**
     * Getter for civiliansSaved.
     * @return Returns the number of civilians this hero saved.
     */
    public int getCiviliansSaved() {
        return this.civiliansSaved;
    }
    
    /**
     * Increases the count of saved civilians.
     */
    public void saveCivilian() {
        this.civiliansSaved++;
        
        this.log("[STATUS] Civilians Saved -> " + this.civiliansSaved);
    }
}
