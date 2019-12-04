package main.java.patterns.factory;

import main.java.patterns.decorator.GroundPoundDecorator;

public class MonsterVillain extends BaseVillain {

    /**
     * Default constructor.
     */
    public MonsterVillain() {
        super(5, "Monster");
        
        this.superPowers.add(new GroundPoundDecorator(20));
    }

}
