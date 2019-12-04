package main.java;

import java.util.Random;

public abstract class BaseLocation {

    private static int count;

    protected static final Random randy = new Random();
    protected int occupants;
    protected String description;

    protected void log(String message) {
        System.out.println(this.description + ": " + message);
    }

    protected static void incrementCount() {
        count++;
    }

    protected static int getCount() {
        return count;
    }

    /**
     * Default constructor.
     * 
     * @param description The description of this location
     */
    public BaseLocation(String description) {
        this.description = description;
    }

    /**
     * Getter for the occupant count.
     * 
     * @return The number of occupants.
     */
    public int getOccupantCount() {
        return this.occupants;
    }

    /**
     * Gets an occupant from the character list.
     * 
     * @param index The index of the character.
     * @return A character from the list.
     */
    public abstract BaseCharacter getOccupant(int index);

    /**
     * Adds an occupant to this location.
     * 
     * @param occupant The occupant to add
     * @return True if adding was successful.
     */
    public abstract boolean addOccupant(BaseCharacter occupant);

    /**
     * Removes an occupant from this location.
     * 
     * @param occupant The occupant to add
     * @return True if adding was successful.
     */
    public abstract boolean removeOccupant(BaseCharacter occupant);

    /**
     * Updates state for objects in this location.
     */
    public abstract void update();
    
    @Override
    public String toString() {
        return this.description;
    }
}
