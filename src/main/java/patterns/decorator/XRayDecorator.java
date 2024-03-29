package main.java.patterns.decorator;

import java.util.ArrayList;
import java.util.Random;

/**
 * X Ray super power that does little to no damage but lets the user
 * see any hidden objects.
 * @author bagoette
 *
 */
public class XRayDecorator extends SuperPowerDecorator {

    private ArrayList<String> objects;
    
    /**
     * Default constructor.
     */
    public XRayDecorator() {
        // X Ray does very little damage
        super(2, "INSERT 1980'S BEEP BOOP BOP BOOP...");
        
        initObjects();
    }

    @Override
    public String attack() {
        return "XRay vision revealed " + this.getXRayedObject();
    }
    
    private void initObjects() {
        objects = new ArrayList<String>();
        objects.add("a bullet-proof vest!");
        objects.add("a mom tattoo... 8-)!");
        objects.add("a fire retardent suit!");
        objects.add("tear gas!");
        objects.add("Spongebob undies...");
        objects.add("an indestructable cup!");
        objects.add("a gun!");
        objects.add("a poison pen!");
        objects.add("a Babe Ruth baseball card!");
        objects.add("nothing...");
        objects.add("cold hard cash..OH YEAH!");
    }
    
    private String getXRayedObject() {
        int count = objects.size();
        
        Random randy = new Random();
        
        return objects.get(randy.nextInt(count));
    }
}
