package main.java;

import java.util.Random;

public abstract class BaseLocation {

    protected static Random randy = new Random();
    protected int occupants;
    protected String description;

    protected void log(String message) {
        System.out.println(this.description + ": " + message);
    }
    
    /**
     * Default constructor.
     * @param description The description of this location
     */
    public BaseLocation(String description) {
        this.description = description;
    }
    
    /**
     * Getter for the occupant count.
     * @return The number of occupants.
     */
    public int getOccupantCount() {
        return this.occupants;
    }
    
    /**
     * Gets an occupant from the character list.
     * @param index The index of the character.
     * @return A character from the list.
     */
    public abstract BaseCharacter getOccupant(int index);
    
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
