package main.java;

public abstract class BaseCharacter {

    private int hitPoints;
    private int maxDamage;
    private boolean isAlive;
    
    /**
     * The starting hit points for all characters
     */
    public static final int STARTING_HITPOINTS = 100;
    
    private void checkIfAlive() {
        if (this.hitPoints <= 0) {
            this.isAlive = false;
        }
    }

    /**
     * Default constructor
     * 
     * @param maxDamage The max this character can take in damage
     */
    public BaseCharacter(int maxDamage) {
        this.maxDamage = maxDamage;
        this.isAlive = true;
    }

    /**
     * Heals the character based on how long they heal for
     * 
     * @param seconds The number of seconds for the character to heal
     */
    public void heal(int seconds) {
        // 1 Hit Point increase for every 2 seconds
        this.hitPoints += seconds / 2;
        
        if (this.hitPoints > STARTING_HITPOINTS) {
            this.hitPoints = STARTING_HITPOINTS;
        }
    }

    /**
     * Deducts hit points from the character up to this character's max damage limit
     * 
     * @param points The number of points to deduct
     */
    public void damage(int points) {
        if (points < this.maxDamage) {
            this.hitPoints -= points;
        } else {
            this.hitPoints -= this.maxDamage;
        }
        
        this.checkIfAlive();
    }
}
