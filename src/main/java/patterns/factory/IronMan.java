package main.java.patterns.factory;

public class IronMan extends BaseHero {

    public IronMan() {
        super(15);
    }

    @Override
    public int attack() {
        return 0;
    }

}
