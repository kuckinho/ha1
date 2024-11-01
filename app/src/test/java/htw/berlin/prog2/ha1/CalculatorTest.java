package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // Meine Tests

    // Multiplikation von Zahlen
    @Test
    @DisplayName("should display result after multiplying two positive digits")
    void testMultiplication() {

        // Neues Objekt erstellen
        Calculator calc = new Calculator();

        // Berechnung
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(9);
        calc.pressEqualsKey();

        // Vergleich erwarteter und aktueller Wert für Test
        String expected = "9";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    // Test für Fehler bei der Clear-Taste
    @Test
    @DisplayName("should only clear screen with single press of clear key")
    void testSingleClearKey() {

        // Neues Objekt erstellen
        Calculator calc = new Calculator();

        // Berechnung
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(9);
        calc.pressClearKey();

        // Vergleich erwarteter und aktueller Wert für Test
        double expectedValue = 1;
        String expectedOperation = "+";
        String expectedScreen = "0";

        double actualValue = calc.readLatestValue();
        String actualOperation = calc.readLatestOperation();
        String actualScreen = calc.readScreen();

        assertEquals(expectedValue, actualValue);
        assertEquals(expectedOperation, actualOperation);
        assertEquals(expectedScreen, actualScreen);
    }

    // Test für Fehler beim mehrfachen Drücken der Gleich-Taste
    @Test
    @DisplayName("should repeat last operation when pressing equals key more than once")
    void testPressTwiceEqualsKey() {

        // Neues Objekt erstellen
        Calculator calc = new Calculator();

        // Berechnung
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(9);
        calc.pressEqualsKey();
        calc.pressEqualsKey();
        calc.pressEqualsKey();

        // Vergleich erwarteter und aktueller Wert für Test
        String expected = "28";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }


}