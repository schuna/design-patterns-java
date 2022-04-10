package StarBuzz;

public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverageOrder1 = new Espresso();
        System.out.println(beverageOrder1.getDescription() + " $" + beverageOrder1.cost());
        Beverage beverageOrder2 = new DarkRoast();
        beverageOrder2 = new Mocha(beverageOrder2);
        beverageOrder2 = new Mocha(beverageOrder2);
        beverageOrder2 = new Whip(beverageOrder2);
        System.out.println(beverageOrder2.getDescription() + " $" + beverageOrder2.cost());
        Beverage beverageOrder3 = new HouseBlend();
        beverageOrder3 = new Soy(beverageOrder3);
        beverageOrder3 = new Mocha(beverageOrder3);
        beverageOrder3 = new Whip(beverageOrder3);
        System.out.println(beverageOrder3.getDescription() + " $" + beverageOrder3.cost());
    }
}
