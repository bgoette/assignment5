package main.java.patterns.mediator;

import java.util.ArrayList;

import main.java.BaseCharacter;
import main.java.BaseLocation;
import main.java.patterns.factory.BaseHero;
import main.java.patterns.factory.BaseVillain;

public class City extends BaseLocation {

    private ArrayList<Lair> villainLairs;
    private ArrayList<HeroBase> heroBases;
    
    public City() {
        villainLairs = new ArrayList<Lair>();
        heroBases = new ArrayList<HeroBase>();
    }
    
    @Override
    public int getOccupants() {
        ArrayList<BaseLocation> locations = new ArrayList<BaseLocation>(villainLairs);
        locations.addAll(heroBases);
        
        return locations.size();
    }

    @Override
    public boolean addOccupant(BaseCharacter occupant) {
        if (occupant.getClass().equals(BaseVillain.class)) {
            return villainLairs.get(randy.nextInt(villainLairs.size())).addOccupant(occupant);
        } else if (occupant.getClass().equals(BaseHero.class)) {
            return heroBases.get(randy.nextInt(heroBases.size())).addOccupant(occupant);
        }
        
        return false;
    }

    @Override
    public boolean removeOccupant(BaseCharacter occupant) {
        boolean removed = false;
        
        if (occupant.getClass().equals(BaseVillain.class)) {
            for (Lair lair : villainLairs) {
                removed = lair.removeOccupant(occupant);
                
                if (removed) {
                    break;
                }
            }
            
            return removed;
        } else if (occupant.getClass().equals(BaseHero.class)) {
            for (HeroBase base : heroBases) {
                removed = base.removeOccupant(occupant);
                
                if (removed) {
                    break;
                }
            }
            
            return removed;
        }
        
        return false;
    }
    
    
}
