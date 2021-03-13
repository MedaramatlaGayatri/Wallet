package Wallet;

public class InSufficientBalanceException extends Exception {
    public InSufficientBalanceException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
