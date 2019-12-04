package main.java.patterns.factory;

import main.java.patterns.decorator.SuperHearingDecorator;

public class NinjaVillain extends BaseVillain {

    public NinjaVillain() {
        super(10, "Ninja");
        
        this.superPowers.add(new SuperHearingDecorator(5));
    }

}
