package main.java;

import main.java.patterns.mediator.City;

public class Main {

    /**
     * Main method for this program.
     * @param args Any command line arguments.
     */
    public static void main(String[] args) {
        City city = new City();
        
        city.beginSimulation();
    }

}
