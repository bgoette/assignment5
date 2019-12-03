package main.java.patterns.factory;

import java.util.Random;

/**
 * Factory for heroes.
 * @author bagoette
 *
 */
public class Factory {

    private static Random randy = new Random();
    private static int numHeroes = 4;
    private static int numVillains = 3;
    
    /**
     * Creates a random hero.
     * @return Returns a random hero.
     */
    public static BaseHero createHero() {
        int num = randy.nextInt(numHeroes);
        
        switch (num) {
            case 0:
                return new Aquaman();

            case 1:
                return new Batman();

            case 2:
                return new IronMan();

            case 3:
                return new Superman();

            default:
                return new Batman();
        }
    }
    
    /**
     * Creates a random villain.
     * @return Returns a random villain.
     */
    public static BaseVillain createVillain() {
        int num = randy.nextInt(numVillains);
        
        switch (num) {
            case 0:
                return new MastermindVillain();

            case 1:
                return new MonsterVillain();

            case 2:
                return new NinjaVillain();

            default:
                return new MastermindVillain();
        }
    }
}
