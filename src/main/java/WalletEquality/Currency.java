package WalletEquality;

public class Currency {
    final double amount;
    final String type;
    static double dollarValueInRupee = 72.74;

    public Currency(double amount, String type) {
        this.amount = amount;
        this.type = type;
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
