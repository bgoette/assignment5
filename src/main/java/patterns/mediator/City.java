package main.java.patterns.mediator;

import java.util.ArrayList;

import main.java.BaseLocation;

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
}
