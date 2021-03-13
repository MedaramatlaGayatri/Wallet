package Wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void testIsXRupeesIsEqualTo1Dollars() {
        Currency rupee = new Currency();
        rupee.setAmount(72.74);
        rupee.setType("Rupee");
        Currency dollar = new Currency();
        dollar.setAmount(1.00);
        dollar.setType("Dollar");

        Wallet wallet = new Wallet(rupee, dollar);
        Boolean actualEquality = wallet.isEqual();

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

        Wallet wallet = new Wallet(dollar, rupee);
        Boolean actualEquality = wallet.isEqual();

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

        Wallet wallet = new Wallet(dollar, rupee);
        Boolean actualEquality = wallet.isEqual();

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

    @Test
    void testIfAmountEqualToXWhenMoneyAddedOnce() {
        Currency rupee = new Currency();
        rupee.setAmount(100);
        rupee.setType("Rupee");
        Wallet wallet = new Wallet();
        wallet.add(rupee);
        double expectedAmountInRupee = 100;
        double expectedAmountInDollar = 1.37;

        double actualAmountInRupee = wallet.amount("Rupee");
        double actualAmountInDollar = wallet.amount("Dollar");

        assertEquals(expectedAmountInRupee,actualAmountInRupee);
        assertEquals(expectedAmountInDollar,actualAmountInDollar);
    }

    @Test
    void testIfAmountEqualToXWhenMoneyAddedNTimes() {
        Currency rupee1 = new Currency();
        rupee1.setAmount(100);
        rupee1.setType("Rupee");
        Currency dollar = new Currency();
        dollar.setAmount(1);
        dollar.setType("Dollar");
        Currency rupee2 = new Currency();
        rupee2.setAmount(100);
        rupee2.setType("Rupee");

        Wallet wallet = new Wallet();
        wallet.add(rupee1);
        wallet.add(dollar);
        wallet.add(rupee2);
        double expectedAmountInRupee = 272.74;
        double expectedAmountInDollar = 3.74;

        double actualAmountInRupee = wallet.amount("Rupee");
        double actualAmountInDollar = wallet.amount("Dollar");

        assertEquals(expectedAmountInRupee,actualAmountInRupee);
        assertEquals(expectedAmountInDollar,actualAmountInDollar);
    }

    @Test
    void testIfAmountEqualToZeroWhenWalletIsEmpty() {
        Wallet wallet = new Wallet();
        double expectedAmountInRupee = 0;
        double expectedAmountInDollar = 0;

        double actualAmountInRupee = wallet.amount("Rupee");
        double actualAmountInDollar = wallet.amount("Dollar");

        assertEquals(expectedAmountInRupee,actualAmountInRupee);
        assertEquals(expectedAmountInDollar,actualAmountInDollar);
    }
}