package main.java.patterns.decorator;

public class SuperPowerDecorator implements ISuperPower {
    
    protected int damageStrength;
    protected String attackMessage;
    
    public SuperPowerDecorator(int damageStrength, String attackMessage) {
        this.damageStrength = damageStrength;
        this.attackMessage = attackMessage;
    }

    @Override
    public String attack() {
        return this.attackMessage;
    }

    /**
     * Increases this super power strength.
     * @param power The amount to increase this power
     */
    @Override
    public void increaseStrength(int power) {
        this.damageStrength += power;
    }

    @Override
    public int getDamageStrength() {
        return this.damageStrength;
    }
}
