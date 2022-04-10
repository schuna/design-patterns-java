package WeatherStation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDataTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void measurementChanged_CalledSuccessful_ReturnsResult() {
        String expected = "Current conditions: 80.0F degrees and 65.0% humidity";
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.measurementChanged();
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void currentConditionDisplay_CalledSuccessful_ReturnsResult() {
        String expected = "Current conditions: 0.0F degrees and 0.0% humidity";
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.removeObserver(currentConditionDisplay);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.measurementChanged();
        currentConditionDisplay.display();
        assertEquals(expected, outContent.toString().trim());
    }
}
