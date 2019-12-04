package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.java.patterns.decorator.ISuperPower;
import main.java.patterns.decorator.SuperHearingDecorator;
import main.java.patterns.factory.Aquaman;
import main.java.patterns.factory.Batman;
import main.java.patterns.factory.IronMan;
import main.java.patterns.factory.MastermindVillain;
import main.java.patterns.factory.MonsterVillain;
import main.java.patterns.factory.NinjaVillain;
import main.java.patterns.factory.Superman;

public class CharacterTest {
    
    private Aquaman aquaman;
    private Batman batman;
    private Superman superman;
    private IronMan ironman;
    private MastermindVillain mastermind;
    private MonsterVillain monster;
    private NinjaVillain ninja;

    @Before
    public void setUp() throws Exception {
        aquaman = new Aquaman();
        batman = new Batman();
        ironman = new IronMan();
        superman = new Superman();
        mastermind = new MastermindVillain();
        monster = new MonsterVillain();
        ninja = new NinjaVillain();
    }
    
    @Test
    public void testVillains() {
        mastermind.attack();
        monster.attack();
        ninja.attack();
    }

    @Test
    public void testAquaman() {
        assertTrue(aquaman.getIsAlive());
        assertTrue(aquaman.getCiviliansSaved() == 0);
        assertTrue(aquaman.getSuperPowers().size() == 1);
        assertTrue(aquaman.attack() == 1);
        
        aquaman.getSuperPowers().remove(0);
        assertTrue(aquaman.attack() == 0);

        aquaman.saveCivilian();
        assertTrue(aquaman.getCiviliansSaved() == 1);
    }

    @Test
    public void testBatman() {
        assertTrue(batman.getIsAlive());
        assertTrue(batman.getCiviliansSaved() == 0);
        assertTrue(batman.getSuperPowers().size() == 1);
        assertTrue(batman.attack() == 10);
        
        batman.getSuperPowers().remove(0);
        assertTrue(batman.attack() == 0);

        batman.saveCivilian();
        assertTrue(batman.getCiviliansSaved() == 1);
    }

    @Test
    public void testIronman() {
        assertTrue(ironman.getIsAlive());
        assertTrue(ironman.getCiviliansSaved() == 0);
        assertTrue(ironman.getSuperPowers().size() == 1);
        assertTrue(ironman.attack() == 6);
        
        ironman.getSuperPowers().remove(0);
        assertTrue(ironman.attack() == 0);

        ironman.saveCivilian();
        assertTrue(ironman.getCiviliansSaved() == 1);
    }

    @Test
    public void testSuperman() {
        assertTrue(superman.getIsAlive());
        assertTrue(superman.getCiviliansSaved() == 0);
        assertTrue(superman.getSuperPowers().size() == 1);
        assertTrue(superman.attack() == 10);
        
        superman.getSuperPowers().remove(0);
        assertTrue(superman.attack() == 0);

        superman.saveCivilian();
        assertTrue(superman.getCiviliansSaved() == 1);
    }

    @Test
    public void testBaseCharacter() {
        superman = new Superman();
        
        superman.levelUp();
        ISuperPower power = new SuperHearingDecorator(10);
        superman.addSuperPower(power);
        assertTrue(superman.getSuperPowers().size() == 2);
        
        ArrayList<ISuperPower> powers = new ArrayList<ISuperPower>();
        powers.add(power);
        
        superman.addSuperPowers(powers);
        
        assertNotNull(superman.hashCode());
        
        superman.heal(2);
        assertTrue(superman.attack() == 0);

        mastermind.heal(2);
        assertTrue(mastermind.attack() == 0);
        
        mastermind.damage(100);
        mastermind.damage(200);

        assertTrue(mastermind.attack() == 0);
        mastermind.update();
        mastermind.update();
        assertTrue(mastermind.attack() == 0);
        
        assertFalse(mastermind.equals(null));
        assertFalse(mastermind.equals(superman));
    }
    
}
