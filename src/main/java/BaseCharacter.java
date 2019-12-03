package main.java;

import java.util.ArrayList;
import java.util.Random;

import main.java.patterns.decorator.ISuperPower;

public abstract class BaseCharacter {

    private int hitPoints;
    private int maxDamage;
    
    protected int ticksLeftToHeal;
    protected boolean isAlive;
    protected String description;
    
    protected ArrayList<ISuperPower> superPowers;
    protected Random randy;
    
    /**
     * The starting hit points for all characters.
     */
    public static final int STARTING_HITPOINTS = 100;
    
    /**
     * Checks if character is alive.
     * @return True if still alive.
     */
    public boolean checkIfAlive() {
        if (this.hitPoints <= 0) {
            this.isAlive = false;
            
            this.log("Hey Sanka, ya dead? Ya mon.");
            
            return false;
        }
        
        return true;
    }

    protected void log(String message) {
        System.out.println(this.description + ": " + message);
    }
    
    /**
     * Default constructor.
     * 
     * @param maxDamage The max this character can take in damage.
     */
    public BaseCharacter(int maxDamage, String description) {
        this.maxDamage = maxDamage;
        this.isAlive = true;
        this.description = description;
        
        superPowers = new ArrayList<ISuperPower>();
        randy = new Random();
    }

    /**
     * Heals the character based on how long they heal for.
     * 
     * @param ticks The number of ticks for the character to heal
     */
    public void heal(int ticks) {
        // 1 Hit Point increase for every 2 seconds
        this.hitPoints += ticks / 2;
        this.ticksLeftToHeal = ticks;
        
        if (this.hitPoints > STARTING_HITPOINTS) {
            this.hitPoints = STARTING_HITPOINTS;
        }
        
        this.log("[HEALING] Added " + ticks / 2 + " points!");
    }

    /**
     * Deducts hit points from the character up to this character's max damage limit.
     * 
     * @param points The number of points to deduct
     */
    public void damage(int points) {
        int damage = points;
        
        if (points > this.maxDamage) {
            damage = this.maxDamage;
        }
        
        this.hitPoints -= damage;
        
        this.log("[DAMAGE] Took " + damage + " points damage!");
        
        this.checkIfAlive();
    }
    
    /**
     * Performs one of this characters super powers.
     */
    public int attack() {
        if (this.ticksLeftToHeal > 0) {
            this.log("[EXHAUSTED] I can't fight I'm nursing a wound!");
        }
        
        if (this.superPowers.size() > 0 || this.isAlive) {
            int powers = this.superPowers.size();
            if (powers <= 0) {
                this.log("[PUNY MORTAL] I AM NOT SUPER!");
                
                return 0;
            }
            
            ISuperPower power = this.superPowers.get(randy.nextInt(this.superPowers.size()));
            int damage = power.getDamageStrength();
            
            this.log("[ATTACK] " + power.attack() + " " + damage + " damage inflicted!");
            
            return damage;
        } else {
            this.log("[ATTACK] I'm sorry Cap'n...I don't have the power! 0 damage inflicted.");
            
            return 0;
        }
    }
    
    /**
     * Called every tick, updates this character
     */
    public void update() {
        if (this.ticksLeftToHeal > 0) {
            this.ticksLeftToHeal--;
            
            this.log("[HEALING] " + this.ticksLeftToHeal + " ticks left to heal.");
        }
    }
    
    @Override
    public String toString() {
        return this.description;
    }
}
