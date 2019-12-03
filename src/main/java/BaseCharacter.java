package main.java;

import java.util.ArrayList;
import java.util.Random;

import main.java.patterns.decorator.ISuperPower;

public abstract class BaseCharacter {

    private int hitPoints;
    private int maxDamage;
    
    protected boolean isAlive;
    protected String description;
    
    protected ArrayList<ISuperPower> superPowers;
    protected Random randy;
    
    /**
     * The starting hit points for all characters
     */
    public static final int STARTING_HITPOINTS = 100;
    
    protected void checkIfAlive() {
        if (this.hitPoints <= 0) {
            this.isAlive = false;
        }
    }

    protected void log(String message) {
        System.out.println(this.description + ": " + message);
    }
    
    /**
     * Default constructor
     * 
     * @param maxDamage The max this character can take in damage
     */
    public BaseCharacter(int maxDamage) {
        this.maxDamage = maxDamage;
        this.isAlive = true;
        this.description = "???";
        
        superPowers = new ArrayList<ISuperPower>();
        randy = new Random();
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
    
    /**
     * Performs one of this characters super powers
     */
    public abstract int attack();
}
