package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.patterns.factory.BaseVillain;
import main.java.patterns.factory.Factory;
import main.java.patterns.factory.MastermindVillain;
import main.java.patterns.factory.MonsterVillain;
import main.java.patterns.factory.NinjaVillain;

public class FactoryTest {

    @Test
    public void testFactory() {
        assertNotNull(Factory.createHero());
        assertNotNull(Factory.createHero());
        assertNotNull(Factory.createHero());
        assertNotNull(Factory.createHero());
        assertNotNull(Factory.createHero());
        assertNotNull(Factory.createHero());
        assertNotNull(Factory.createVillain());
        assertNotNull(Factory.createVillain());
        assertNotNull(Factory.createVillain());
        assertNotNull(Factory.createVillain());
        assertNotNull(Factory.createVillain());
        assertNotNull(Factory.createVillain());
        
        BaseVillain villain = Factory.createVillain();
        assertNotNull(Factory.clone(villain));
        assertNotNull(Factory.clone(new MastermindVillain()));
        assertNotNull(Factory.clone(new MonsterVillain()));
        assertNotNull(Factory.clone(new NinjaVillain()));
    }

}
