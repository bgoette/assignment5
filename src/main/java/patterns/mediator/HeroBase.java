package main.java.patterns.mediator;

import java.util.ArrayList;

import main.java.BaseCharacter;
import main.java.BaseLocation;
import main.java.patterns.factory.BaseHero;

public class HeroBase extends BaseLocation {
    
    private ArrayList<BaseHero> heroes;
    
    /**
     * Default constructor.
     */
    public HeroBase() {
        heroes = new ArrayList<BaseHero>();
    }

    @Override
    public boolean addOccupant(BaseCharacter occupant) {
        if (occupant.getClass().equals(BaseHero.class)) {
            if (heroes.size() >= 5) {
                return false;
            }
            
            heroes.add((BaseHero)occupant);
            this.occupants++;
            
            return true;
        }
        
        return false;
    }

    @Override
    public boolean removeOccupant(BaseCharacter occupant) {
        if (occupant.getClass().equals(BaseHero.class)) {
            if (heroes.contains(occupant)) {
                heroes.remove((BaseHero)occupant);
                
                this.occupants--;
                return true;
            }
        }
        
        return false;
    }

}
