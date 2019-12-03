package main.java.patterns.mediator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import main.java.BaseCharacter;
import main.java.BaseLocation;
import main.java.patterns.factory.*;

public class City extends BaseLocation {

    private ArrayList<Lair> villainLairs;
    private ArrayList<HeroBase> heroBases;
    private Timer simulationTimer;

    /**
     * Half second tick rate.
     */
    private static final int TICK_RATE = 500;

    /**
     * Default constructor.
     */
    public City() {
        super("MetroGothamOpolis");
        
        villainLairs = new ArrayList<Lair>();
        heroBases = new ArrayList<HeroBase>();
        simulationTimer = new Timer(true);
    }

    /**
     * Begins the simulation of the super hero world
     */
    public void beginSimulation() {
        Lair lair = new Lair();
        lair.addOccupant(new MastermindVillain());
        lair.addOccupant(new MonsterVillain());
        lair.addOccupant(new NinjaVillain());

        villainLairs.add(lair);

        HeroBase base = new HeroBase();
        base.addOccupant(new Aquaman());
        base.addOccupant(new Superman());
        base.addOccupant(new Batman());
        base.addOccupant(new IronMan());
        
        heroBases.add(base);

        simulationTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                simulationUpdate();
            }
        }, 0, TICK_RATE);
        
        try {
            Thread.sleep(1000);
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

    private void simulationUpdate() {
        int heroBaseIndex = randy.nextInt(heroBases.size());
        HeroBase heroBase = heroBases.get(heroBaseIndex);
        int heroes = heroBase.getOccupantCount();
        
        if (heroes <= 0) {
            this.simulationTimer.cancel();
            
            this.log("[MAYHEM] THE VILLAINS WIN!");
            return;
        }
        
        int heroIndex = randy.nextInt(heroes);
        BaseHero hero = (BaseHero)heroBase.getOccupant(heroIndex);
        
        int lairIndex = randy.nextInt(villainLairs.size());
        Lair lair = villainLairs.get(lairIndex);
        
        int villains = lair.getOccupantCount();
        
        if (villains <= 0) {
            this.simulationTimer.cancel();
            
            this.log("[JOYOUS] THE HEROES WIN!");
            return;
        }
        int villainIndex = randy.nextInt(lair.getOccupantCount());
        BaseVillain villain = (BaseVillain)lair.getOccupant(villainIndex);
        
        int attackDamage = hero.attack();
        
        if (attackDamage > 0) {
            villain.damage(attackDamage);
            
            attackDamage = villain.attack();
        } else {
            attackDamage = villain.attack() + 1;
        }
        
        hero.damage(attackDamage);
        
        if (hero.checkIfAlive()) {
            if (villain.checkIfAlive()) {
                this.log("[BATTLE] The war must continue!");
            } else {
                hero.saveCivilian();
            }
        }
    }

    @Override
    public BaseCharacter getOccupant(int index) {
        return null;
    }
}
