package Wallet;

public class ZeroDepositOrWithdrawException extends Exception {
    public ZeroDepositOrWithdrawException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
