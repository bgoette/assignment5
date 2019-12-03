package main.java;

import java.util.Random;

public abstract class BaseLocation {

    protected static Random randy = new Random();
    protected int occupants;
    
    /**
     * Getter for the occupant count.
     * @return The number of occupants.
     */
    public int getOccupants() {
        return this.occupants;
    }
    
    /**
     * Adds an occupant to this location.
     * @param occupant The occupant to add
     * @return True if adding was successful.
     */
    public abstract boolean addOccupant(BaseCharacter occupant);

    /**
     * Removes an occupant from this location.
     * @param occupant The occupant to add
     * @return True if adding was successful.
     */
    public abstract boolean removeOccupant(BaseCharacter occupant);
}
