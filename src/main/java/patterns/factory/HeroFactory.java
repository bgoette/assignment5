package main.java.patterns.factory;

import java.util.Random;

/**
 * Factory for heroes.
 * @author bagoette
 *
 */
public class HeroFactory {

    private static Random randy = new Random();
    private static int numHeroes = 3;
    
    /**
     * Creates a random hero.
     * @return Returns a random hero.
     */
    public static BaseHero CreateHero() {
        int num = randy.nextInt(numHeroes);
        
        switch (num) {
            case 0:
                return new Batman();

            case 1:
                return new IronMan();

            case 2:
                return new Superman();

            default:
                return new Batman();
        }
    }
}
