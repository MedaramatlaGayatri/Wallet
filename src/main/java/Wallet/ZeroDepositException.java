package Wallet;

public class ZeroDepositException extends Exception {
    public ZeroDepositException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
