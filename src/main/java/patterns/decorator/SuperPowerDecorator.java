package main.java.patterns.decorator;

public class SuperPowerDecorator implements ISuperPower {
    
    protected int damageStrength;
    
    public SuperPowerDecorator(int damageStrength) {
        this.damageStrength = damageStrength;
    }

    @Override
    public String attack() {
        return null;
    }

}
