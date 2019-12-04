package main.java;

import main.java.patterns.decorator.GroundPoundDecorator;
import main.java.patterns.decorator.LaserBeamDecorator;
import main.java.patterns.decorator.SuperHearingDecorator;
import main.java.patterns.decorator.XRayDecorator;
import main.java.patterns.factory.BaseHero;
import main.java.patterns.factory.BaseVillain;
import main.java.patterns.factory.Factory;
import main.java.patterns.factory.Superman;
import main.java.patterns.mediator.City;
import main.java.patterns.mediator.HeroBase;
import main.java.patterns.mediator.Lair;

public class Main {

    /**
     * Main method for this program.
     * @param args Any command line arguments.
     */
    public static void main(String[] args) {
        
        // 
        // Factory Pattern - creates Villains and Heroes 
        //
        
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
        
        // Can also clone a Villain
        BaseVillain original = Factory.createVillain();
        BaseVillain cloned = Factory.clone(original);
        
        System.out.println("original == cloned ? " + original.equals(cloned));
        
        // 
        // Decorator Pattern - gives heroes/villains super powers
        // at runtime
        //
        
        // Specifying Superman so I know what power he starts with
        BaseHero hero = new Superman();
        System.out.println("Super Power Count: " + hero.getSuperPowers().size());
        System.out.println();

        // Attack uses random powers
        hero.attack();
        hero.attack();
        hero.attack();
        hero.attack();
        hero.attack();
        
        hero.addSuperPower(new XRayDecorator());
        hero.addSuperPower(new GroundPoundDecorator(20));
        hero.addSuperPower(new SuperHearingDecorator(2));
        System.out.println("Super Power Count: " + hero.getSuperPowers().size());
        System.out.println();
        
        // Attack uses random powers
        hero.attack();
        hero.attack();
        hero.attack();
        hero.attack();
        hero.attack();

        System.out.println();
        System.out.println("*** SIMULATION BEGINNING ***\n\n\n");
        
        // 
        // Mediator Pattern - The City class handles all the interactions
        // between the heroes and the villains. 
        // 
        // PLEASE VIEW THE simulationUpdate() METHOD INSIDE THE City.java CLASS
        // TO VIEW THE MEDIATOR PATTERN
        //
        
        // Create a city with the base and lair created above
        City city = new City(lair, base);
        
        // Start the simulation
        city.beginSimulation();
    }

}
