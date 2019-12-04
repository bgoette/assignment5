package main.java.patterns.factory;

import main.java.BaseCharacter;
import main.java.patterns.decorator.SuperDisasterPlanDecorator;
import main.java.patterns.decorator.XRayDecorator;

public class MastermindVillain extends BaseVillain {

    /**
     * Default constructor.
     */
    public MastermindVillain() {
        super(BaseCharacter.STARTING_HITPOINTS, "Mastermind");
        
        this.superPowers.add(new XRayDecorator());
        this.superPowers.add(new SuperDisasterPlanDecorator(15));
    }
    
}
