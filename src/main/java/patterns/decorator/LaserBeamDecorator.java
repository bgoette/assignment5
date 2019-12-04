package main.java.patterns.decorator;

public class LaserBeamDecorator extends SuperPowerDecorator {

    public LaserBeamDecorator(int damageStrength) {
        super(damageStrength, "Pew pew pew, bbzzzzshhhhhooooom!");
    }

}
