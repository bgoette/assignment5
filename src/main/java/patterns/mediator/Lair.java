package main.java.patterns.mediator;

import java.util.ArrayList;

import main.java.BaseCharacter;
import main.java.BaseLocation;
import main.java.patterns.factory.BaseVillain;

public class Lair extends BaseLocation {

    private ArrayList<BaseVillain> villains;

    /**
     * Default constructor.
     */
    public Lair() {
        super("Villain Lair " + getCount());
        incrementCount();
        
        villains = new ArrayList<BaseVillain>();
    }

    @Override
    public boolean addOccupant(BaseCharacter occupant) {
        
        if (occupant instanceof BaseVillain) {
            if (villains.size() >= 5) {
                return false;
            }

            villains.add((BaseVillain) occupant);
            this.occupants++;

            this.log("[SPAWN] " + occupant.toString() + " spawns to wreak havoc!");

            return true;
        }

        return false;
    }

    @Override
    public boolean removeOccupant(BaseCharacter occupant) {
        if (occupant instanceof BaseVillain) {
            if (villains.contains(occupant)) {
                villains.remove((BaseVillain) occupant);

                this.occupants--;

                this.log("[DEATH] " + occupant.toString() + ", a villain, has been eradicated!");

                return true;
            }
        }

        return false;
    }

    @Override
    public BaseCharacter getOccupant(int index) {
        return villains.get(index);
    }

    @Override
    public void update() {
        for (BaseVillain villain : villains) {
            villain.update();
        }
    }
}
