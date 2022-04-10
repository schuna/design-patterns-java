package StarBuzz;

public class Espresso extends Beverage {
    public Espresso() {
        description = "StarBuzz.Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
