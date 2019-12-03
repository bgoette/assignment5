package main.java.patterns.decorator;

public class SuperPowerDecorator implements ISuperPower {
    
    protected int damageStrength;
    
    public SuperPowerDecorator(int damageStrength) {
        this.damageStrength = damageStrength;
    }

    @Override
    public String attack() {
        return "Fighting Fisting Fisticuffs!";
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
