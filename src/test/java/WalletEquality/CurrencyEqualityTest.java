package WalletEquality;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyEqualityTest {
    @Test
    void testIsXRupeesIsEqualTo1Dollars() {
        Currency rupee = new Currency();
        rupee.setAmount(72.74);
        rupee.setType("Rupee");
        Currency dollar = new Currency();
        dollar.setAmount(1.00);
        dollar.setType("Dollar");

        CurrencyEquality currencyequality = new CurrencyEquality(rupee, dollar);
        Boolean actualEquality = currencyequality.isEqual();

        assertEquals(true, actualEquality);
    }

    @Test
    void testIsXRupeesIsEqualToYDollars() {
        Currency rupee = new Currency();
        rupee.setAmount(36.37);
        rupee.setType("Rupee");
        Currency dollar = new Currency();
        dollar.setAmount(0.5);
        dollar.setType("Dollar");

        CurrencyEquality currencyequality = new CurrencyEquality(dollar, rupee);
        Boolean actualEquality = currencyequality.isEqual();

        assertEquals(true, actualEquality);
    }

    @Test
    void testIsZeroRupeesIsEqualToZeroDollars() {
        Currency rupee = new Currency();
        rupee.setAmount(0);
        rupee.setType("Rupee");
        Currency dollar = new Currency();
        dollar.setAmount(0);
        dollar.setType("Dollar");

        CurrencyEquality currencyequality = new CurrencyEquality(dollar, rupee);
        Boolean actualEquality = currencyequality.isEqual();

        assertEquals(true, actualEquality);
    }

    @Test
    void testCurrencyThrowsExceptionIfNegative() {
        String expectedExceptionMessage = "Currency Does not Support Negative Values";
        Currency rupee = new Currency();
        Currency dollar = new Currency();

        String actualExceptionMessageOfRupeeCurrency = rupee.setAmount(-10);
        String actualExceptionMessageOfDollarCurrency = dollar.setAmount(-37);

        assertEquals(expectedExceptionMessage, actualExceptionMessageOfRupeeCurrency);
        assertEquals(expectedExceptionMessage, actualExceptionMessageOfDollarCurrency);
    }
}