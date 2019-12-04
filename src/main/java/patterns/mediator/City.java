package main.java.patterns.mediator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import main.java.BaseCharacter;
import main.java.BaseLocation;
import main.java.patterns.factory.BaseHero;
import main.java.patterns.factory.BaseVillain;
import main.java.patterns.factory.Factory;

public class City extends BaseLocation {

    private ArrayList<Lair> villainLairs;
    private ArrayList<HeroBase> heroBases;
    private Timer simulationTimer;

    private boolean simulationRunning;

    /**
     * Half second tick rate.
     */
    private static final int TICK_RATE = 50;

    /**
     * Default constructor.
     */
    public City(Lair lair, HeroBase base) {
        super("MetroGothamOpolis");

        villainLairs = new ArrayList<Lair>();
        villainLairs.add(lair);

        heroBases = new ArrayList<HeroBase>();
        heroBases.add(base);

        simulationTimer = new Timer(true);
    }

    /**
     * Begins the simulation of the super hero world.
     */
    public void beginSimulation() {
        simulationRunning = true;

        simulationTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                simulationUpdate();
            }
        }, 0, TICK_RATE);

        try {
            while (simulationRunning) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getOccupantCount() {
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

    private void endSimulation(String message) {
        this.simulationTimer.cancel();
        this.simulationRunning = false;

        this.log(message);
    }

    /**
     * Runs on a set tick timer. This implements most of the requirements
     * for the Mediator Pattern.
     */
    private void simulationUpdate() {
        
        // If there are no hero bases left, the villains win
        if (heroBases.size() <= 0) {
            endSimulation("[MAYHEM] THE VILLAINS WIN!");
            return;
        }

        int heroBaseIndex = randy.nextInt(heroBases.size());
        HeroBase heroBase = heroBases.get(heroBaseIndex);
        int heroes = heroBase.getOccupantCount();

        // If no heroes left, the villains win
        if (heroes <= 0) {
            endSimulation("[MAYHEM] THE VILLAINS WIN!");
            return;
        }

        int heroIndex = randy.nextInt(heroes);
        BaseHero hero = (BaseHero) heroBase.getOccupant(heroIndex);

        // If there are no villain lairs left, the heroes win
        if (villainLairs.size() <= 0) {
            endSimulation("[JOYOUS] THE HEROES WIN!");
            return;
        }

        int lairIndex = randy.nextInt(villainLairs.size());
        Lair lair = villainLairs.get(lairIndex);

        int villains = lair.getOccupantCount();

        // If there are no villains left, the heroes win
        if (villains <= 0) {
            endSimulation("[JOYOUS] THE HEROES WIN!");
            return;
        }

        int villainIndex = randy.nextInt(lair.getOccupantCount());
        BaseVillain villain = (BaseVillain) lair.getOccupant(villainIndex);

        //
        // Mediator - Initiates hero attack and applies
        // to villain if > 0. Villain can then attack hero and
        // does more damage if hero had no attack damage
        //
        int attackDamage = hero.attack();

        if (attackDamage > 0) {
            villain.damage(attackDamage);

            attackDamage = villain.attack();
        } else {
            attackDamage = villain.attack() + 1;
        }

        hero.damage(attackDamage);

        // If hero is still alive...
        if (hero.getIsAlive()) {
            
            // If villain is still alive, the battle continue's
            if (villain.getIsAlive()) {
                this.log("[BATTLE] The war must continue!");
                
                // Heal for the next 1 to 3 ticks
                villain.heal(randy.nextInt(3) + 1);
            } else {
                
                // Villain is dead, so increase civilians saved for hero
                hero.saveCivilian();
                
                // Level up the hero for winning this battle
                hero.levelUp();
                
                // Give hero the super powers of the villain
                hero.addSuperPowers(villain.getSuperPowers());

                // Remove villain from lair
                lair.removeOccupant(villain);

                // If no more villains in lair, it is destroyed and removed from city
                if (lair.getOccupantCount() <= 0) {
                    this.log("[SMALL VICTORY] " + lair.toString() + " has been destroyed!");
                    villainLairs.remove(lair);
                }
            }
            
            // Heal for the next 1 to 3 ticks
            hero.heal(randy.nextInt(3) + 1);
        } else {
            if (villain.getIsAlive()) {
                // Heal for the next 1 to 3 ticks
                villain.heal(randy.nextInt(3) + 1);
                villain.levelUp();

                BaseVillain newVillain = Factory.clone(villain);

                boolean addSuccess = lair.addOccupant(newVillain);

                if (!addSuccess) {
                    Lair newLair = new Lair();
                    newLair.addOccupant(newVillain);

                    villainLairs.add(newLair);
                }
            }

            heroBase.removeOccupant(hero);

            if (heroBase.getOccupantCount() <= 0) {
                this.log("[COLLAPSE] " + heroBase.toString() + " has been destroyed!");
                heroBases.remove(heroBase);
            }
        }

        for (HeroBase base : heroBases) {
            base.update();
        }

        for (Lair villainLair : villainLairs) {
            villainLair.update();
        }

        this.log("[ROUND] COMPLETE!!!\n\n");
    }

    @Override
    public BaseCharacter getOccupant(int index) {
        return null;
    }

    @Override
    public void update() {
    }
}
