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
    protected int powerLevel;

    /**
     * Default constructor.
     * 
     * @param maxDamage The max this character can take in damage.
     */
    public BaseCharacter(int maxDamage, String description) {
        this.maxDamage = maxDamage;
        this.isAlive = true;
        this.description = description;
        this.hitPoints = STARTING_HITPOINTS;
        
        superPowers = new ArrayList<ISuperPower>();
        randy = new Random();
    }
    
    /**
     * Increases this hero's power level.
     */
    public void levelUp() {
        this.powerLevel++;
        
        this.log("[STATUS] Power Level -> " + this.powerLevel);
    }
    
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
            
            this.log("[STATUS] Hey Sanka, ya dead? Ya mon.");
            
            return false;
        }
        
        return true;
    }
    
    /**
     * Getter for isAlive.
     * @return True if character is alive
     */
    public boolean getIsAlive() {
        return this.isAlive;
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
            
            return 0;
        }
        
        if (this.superPowers.size() > 0 && this.isAlive) {
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
     * Called every tick, updates this character.
     */
    public void update() {
        if (this.ticksLeftToHeal > 0) {
            this.ticksLeftToHeal--;
            
            this.log("[HEALING] " + this.ticksLeftToHeal + " ticks left to heal.");
        }
    }
    
    /**
     * Adds the given super power to this character.
     * @param power The power to add.
     */
    public void addSuperPower(ISuperPower power) {
        this.superPowers.add(power);
    }
    
    /**
     * Adds the given super powers to this character.
     * @param powers The powers to add.
     */
    public void addSuperPowers(ArrayList<ISuperPower> powers) {
        
        // List of powers to remove if already owned
        ArrayList<ISuperPower> powersToRemove = new ArrayList<ISuperPower>();
        
        // Check if this character has any of the given powers yet
        for (ISuperPower power : powers) {
            for (ISuperPower myPower : this.superPowers) {
                if (power.getClass().equals(myPower.getClass())) {
                    
                    //
                    // Fulfills requirement to increase super power strength
                    // if character already has this ability
                    //
                    myPower.increaseStrength(5);
                    powersToRemove.add(power);
                    
                    break;
                }
            }
        }
        
        // Remove any powers we already have
        powers.removeAll(powersToRemove);
        
        // Add the remaining powers
        this.superPowers.addAll(powers);
    }
    
    /**
     * Gets this character's super powers.
     * @return This character's super powers.
     */
    public ArrayList<ISuperPower> getSuperPowers() {
        return this.superPowers;
    }
    
    @Override
    public String toString() {
        return this.description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        
        if (!(obj instanceof BaseCharacter)) {
            return false;
        }
        
        BaseCharacter other = (BaseCharacter)obj;
        
        if (!other.description.equals(this.description)) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.description.hashCode() + this.getSuperPowers().hashCode();
    }
    
    protected void log(String message) {
        System.out.println(this.description + ": " + message);
    }
}
