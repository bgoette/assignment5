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
        super("Hero Base " + getCount());
        incrementCount();
        
        heroes = new ArrayList<BaseHero>();
    }

    @Override
    public boolean addOccupant(BaseCharacter occupant) {
        if (occupant instanceof BaseHero) {
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
        if (occupant instanceof BaseHero) {
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

    @Override
    public void update() {
        for (BaseHero hero : heroes) {
            hero.update();
        }
    }
}
