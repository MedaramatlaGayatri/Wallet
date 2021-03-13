package Wallet;

public class Currency {
    private double amount;
    private String type;
    static double dollarValueInRupee = 72.74;

    public void setType(String type) {
        this.type = type;
    }

    public String setAmount(double amount) {
        try {
            if (!checkForNegativeCurrencyValue(amount))
                this.amount = amount;
        } catch (NegativeCurrencyValueException e) {
            return e.getMessage();
        }
        return "";
    }

    private boolean checkForNegativeCurrencyValue(double amount) throws NegativeCurrencyValueException {
        if (amount < 0)
            throw new NegativeCurrencyValueException("Amount Does not Support Negative Values");
        return false;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public static double getDollarValueInRupee() {
        return dollarValueInRupee;
    }

    public void setDollarValueInRupee(double dollarValueInRupee) {
        Currency.dollarValueInRupee = dollarValueInRupee;
    }
}
