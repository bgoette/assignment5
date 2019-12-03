package main.java.patterns.mediator;

import java.util.ArrayList;

import main.java.BaseCharacter;
import main.java.BaseLocation;
import main.java.patterns.factory.BaseHero;

public class HeroBase extends BaseLocation {
    
    private ArrayList<BaseHero> heroes;
    private static int count;
    
    /**
     * Default constructor.
     */
    public HeroBase() {
        super("Hero Base " + count++);
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
            
            this.log("[BIRTH] " + occupant.toString() + " is born this day!");
            
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
                
                this.log("[DEATH] " + occupant.toString() + ", a hero, has fallen...");
                
                return true;
            }
        }
        
        return false;
    }

    @Override
    public BaseCharacter getOccupant(int index) {
        return heroes.get(index);
    }

}
