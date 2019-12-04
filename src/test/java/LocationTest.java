package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import main.java.patterns.factory.Aquaman;
import main.java.patterns.factory.BaseHero;
import main.java.patterns.factory.BaseVillain;
import main.java.patterns.factory.Batman;
import main.java.patterns.factory.MastermindVillain;
import main.java.patterns.factory.Superman;
import main.java.patterns.mediator.City;
import main.java.patterns.mediator.HeroBase;
import main.java.patterns.mediator.Lair;

import org.junit.Test;

public class LocationTest {

    private City city;
    private Lair lair;
    private HeroBase base;

    @Test
    public void testLocations() {
        lair = new Lair();
        assertTrue(lair.getOccupantCount() == 0);
        BaseVillain master = new MastermindVillain();
        lair.addOccupant(master);
        assertTrue(lair.getOccupantCount() == 1);
        assertNotNull(lair.getOccupant(0));
        lair.removeOccupant(master);
        lair.addOccupant(master);

        base = new HeroBase();
        assertTrue(base.getOccupantCount() == 0);
        BaseHero hero = new Superman();
        base.addOccupant(hero);
        assertTrue(base.getOccupantCount() == 1);
        assertNotNull(base.getOccupant(0));
        base.removeOccupant(hero);
        base.addOccupant(new Aquaman());

        city = new City(lair, base);
        assertTrue(city.getOccupantCount() == 2);
        city.addOccupant(new Batman());
        city.addOccupant(new MastermindVillain());
        assertFalse(city.getSimulationRunning());
        city.getTotalHeroesLeft();
        city.getTotalVillainsLeft();

        city.beginSimulation();

        assertNull(city.getOccupant(0));
        city.update();

    }

}
