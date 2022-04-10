package StarBuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StarBuzzCoffeeTest {
    @ParameterizedTest
    @MethodSource("beverageOrder")
    public void beverageOrder_WithoutCondiments_ReturnsCost(Beverage beverage, String expected) {
        String result = beverage.getDescription() + " $" + beverage.cost();
        assertEquals(expected, result);
    }

    private static Stream<Arguments> beverageOrder() {
        return Stream.of(
                Arguments.of(new Espresso(), "StarBuzz.Espresso $1.99"),
                Arguments.of(new DarkRoast(), "Dark Roast Coffee $0.99"),
                Arguments.of(new HouseBlend(), "House Blend Coffee $0.89")
        );
    }

    @ParameterizedTest
    @MethodSource("beverageOrderWithCondiments")
    public void beverageOrder_WithCondiments_ReturnsCost(Beverage beverage, String expected) {
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        beverage = new Soy(beverage);
        String result = beverage.getDescription() + " $" + beverage.cost();
        assertEquals(expected, result);
    }

    private static Stream<Arguments> beverageOrderWithCondiments() {
        return Stream.of(
                Arguments.of(new Espresso(), "StarBuzz.Espresso, StarBuzz.Mocha, StarBuzz.Mocha, Whipping Cream, StarBuzz.Soy $2.64"),
                Arguments.of(new DarkRoast(), "Dark Roast Coffee, StarBuzz.Mocha, StarBuzz.Mocha, Whipping Cream, StarBuzz.Soy $1.64"),
                Arguments.of(new HouseBlend(), "House Blend Coffee, StarBuzz.Mocha, StarBuzz.Mocha, Whipping Cream, StarBuzz.Soy $1.54")
        );
    }
}