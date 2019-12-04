package main.java;

import main.java.patterns.factory.Factory;
import main.java.patterns.mediator.City;
import main.java.patterns.mediator.HeroBase;
import main.java.patterns.mediator.Lair;

public class Main {

    /**
     * Main method for this program.
     * @param args Any command line arguments.
     */
    public static void main(String[] args) {
        Lair lair = new Lair();
        lair.addOccupant(Factory.createVillain());
        lair.addOccupant(Factory.createVillain());
        lair.addOccupant(Factory.createVillain());
        lair.addOccupant(Factory.createVillain());
        lair.addOccupant(Factory.createVillain());

        HeroBase base = new HeroBase();
        base.addOccupant(Factory.createHero());
        base.addOccupant(Factory.createHero());
        base.addOccupant(Factory.createHero());
        base.addOccupant(Factory.createHero());
        base.addOccupant(Factory.createHero());
        
        City city = new City(lair, base);
        
        city.beginSimulation();
    }

}
