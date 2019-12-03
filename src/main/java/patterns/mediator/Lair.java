package main.java.patterns.mediator;

import java.util.ArrayList;

import main.java.BaseCharacter;
import main.java.BaseLocation;
import main.java.patterns.factory.BaseVillain;

public class Lair extends BaseLocation {
    
    private ArrayList<BaseVillain> villains;
    
    /**
     * Default constructor.
     */
    public Lair() {
        villains = new ArrayList<BaseVillain>();
    }

    @Override
    public boolean addOccupant(BaseCharacter occupant) {
        if (occupant.getClass().equals(BaseVillain.class)) {
            if (villains.size() >= 5) {
                return false;
            }
            
            villains.add((BaseVillain)occupant);
            this.occupants++;
            
            return true;
        }
        
        return false;
    }

    @Override
    public boolean removeOccupant(BaseCharacter occupant) {
        if (occupant.getClass().equals(BaseVillain.class)) {
            if (villains.contains(occupant)) {
                villains.remove((BaseVillain)occupant);
                
                this.occupants--;
                return true;
            }
        }
        
        return false;
    }

}
