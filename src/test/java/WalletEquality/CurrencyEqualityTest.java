package WalletEquality;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyEqualityTest {
    @Test
    void testIsXRupeesIsEqualTo1Dollars() {
        Currency rupee = new Currency(72.74, "Rupee");
        Currency dollar = new Currency(1.00, "Dollar");

    }
}
