package main.java.patterns.factory;

import main.java.BaseCharacter;

public abstract class BaseHero extends BaseCharacter {

    protected int civiliansSaved;
    protected int powerLevel;
    
    /**
     * Increases this hero's power level.
     */
    protected void levelUp() {
        this.powerLevel++;
        
        this.log("Power Level -> " + this.powerLevel);
    }

    /**
     * Default constructor.
     * @param maxDamage The max this character can take in damage.
     */
    public BaseHero(int maxDamage) {
        super(maxDamage);

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
        
        this.log("Civilians Saved -> " + this.civiliansSaved);
    }
}
