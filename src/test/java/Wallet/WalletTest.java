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
    void testThrowsExceptionIfAmountIsNegative() {
        String expectedExceptionMessage = "Amount Does not Support Negative Values";
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
        wallet.deposit(rupee);
        double expectedAmountInRupee = 100;
        double expectedAmountInDollar = 1.37;

        double actualAmountInRupee = wallet.amount("Rupee");
        double actualAmountInDollar = wallet.amount("Dollar");

        assertEquals(expectedAmountInRupee, actualAmountInRupee);
        assertEquals(expectedAmountInDollar, actualAmountInDollar);
    }

    @Test
    void testIfAmountEqualToYWhenMoneyAddedNTimes() {
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
        wallet.deposit(rupee1);
        wallet.deposit(dollar);
        wallet.deposit(rupee2);
        double expectedAmountInRupee = 272.74;
        double expectedAmountInDollar = 3.75;

        double actualAmountInRupee = wallet.amount("Rupee");
        double actualAmountInDollar = wallet.amount("Dollar");

        assertEquals(expectedAmountInRupee, actualAmountInRupee);
        assertEquals(expectedAmountInDollar, actualAmountInDollar);
    }

    @Test
    void testIfAmountEqualToZeroWhenWalletIsEmpty() {
        Wallet wallet = new Wallet();
        double expectedAmountInRupee = 0;
        double expectedAmountInDollar = 0;

        double actualAmountInRupee = wallet.amount("Rupee");
        double actualAmountInDollar = wallet.amount("Dollar");

        assertEquals(expectedAmountInRupee, actualAmountInRupee);
        assertEquals(expectedAmountInDollar, actualAmountInDollar);
    }

    @Test
    void testIfMoneyIsAddedToWallet() {
        Currency rupee = new Currency();
        rupee.setAmount(50.1);
        rupee.setType("Rupee");
        String expectedDepositMessage = "50.1 Rupee is Deposited Into The Wallet";

        Wallet wallet = new Wallet();
        String actualDepositMessage = wallet.deposit(rupee);

        assertEquals(expectedDepositMessage, actualDepositMessage);
    }

    @Test
    void testThrowsExceptionIfMoneyDepositedIsZero() {
        Currency dollar = new Currency();
        dollar.setAmount(0);
        dollar.setType("Dollar");
        String expectedExceptionMessage = "Minimum Amount To be Deposited Or Withdrawn : 1";

        Wallet wallet = new Wallet();
        String actualExceptionMessageOfDollarCurrency = wallet.deposit(dollar);

        assertEquals(expectedExceptionMessage, actualExceptionMessageOfDollarCurrency);
    }

    @Test
    void testIfMoneyIsWithDrawnFromWallet() {
        Currency depositAmount = new Currency();
        depositAmount.setAmount(200);
        depositAmount.setType("Rupees");
        Currency withdrawAmount = new Currency();
        withdrawAmount.setAmount(2);
        withdrawAmount.setType("Dollar");
        String expectedWithdrawMessage = "2.0 Dollar is Withdrawn From The wallet";

        Wallet wallet = new Wallet();
        wallet.deposit(depositAmount);
        String actualWithdrawMessage = wallet.withdraw(withdrawAmount);

        assertEquals(expectedWithdrawMessage, actualWithdrawMessage);
    }

    @Test
    void testThrowsExceptionIfWithdrawAmountGreaterThanAvailableBalance() {
        Currency depositAmount = new Currency();
        depositAmount.setAmount(200);
        depositAmount.setType("Rupee");
        Currency withdrawAmount = new Currency();
        withdrawAmount.setAmount(3);
        withdrawAmount.setType("Dollar");
        String expectedExceptionMessage = "Available Balance is Not Sufficient";

        Wallet wallet = new Wallet();
        wallet.deposit(depositAmount);
        String actualExceptionMessage = wallet.withdraw(withdrawAmount);

        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    void testThrowsExceptionIfMoneyWithdrawnIsZero() {
        Currency dollar = new Currency();
        dollar.setAmount(0);
        dollar.setType("Dollar");
        String expectedExceptionMessage = "Minimum Amount To be Deposited Or Withdrawn : 1";

        Wallet wallet = new Wallet();
        String actualExceptionMessageOfDollarCurrency = wallet.withdraw(dollar);

        assertEquals(expectedExceptionMessage, actualExceptionMessageOfDollarCurrency);
    }

    @Test
    void testThrowsExceptionIfWithdrawIsDoneOnAEmptyWallet() {
        String expectedExceptionMessage = "Available Balance is Not Sufficient";
        Currency withdrawAmount = new Currency();
        withdrawAmount.setAmount(100);
        withdrawAmount.setType("Rupee");

        Wallet wallet = new Wallet();
        String actualExceptionMessage = wallet.withdraw(withdrawAmount);

        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

}