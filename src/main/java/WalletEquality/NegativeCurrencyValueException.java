package WalletEquality;

public class NegativeCurrencyValueException extends Exception {
    public NegativeCurrencyValueException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
