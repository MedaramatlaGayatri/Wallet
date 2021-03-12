package WalletEquality;

import static WalletEquality.Currency.getDollarValueInRupee;

public class CurrencyEquality {
    Currency currency1, currency2;

    CurrencyEquality(Currency Currency1, Currency Currency2) {
        this.currency1 = Currency1;
        this.currency2 = Currency2;
    }

    private String convertRupeeIntoDollar() {
        double dollarValue = getDollarValueInRupee();
        double currency1Amount = currency1.getAmount();
        return String.format("%.2f", currency1Amount * dollarValue);
    }

    private String convertDollarIntoRupee() {
        double dollarValue = getDollarValueInRupee();
        double currency1Amount = currency1.getAmount();
        return String.format("%.2f", currency1Amount / dollarValue);
    }

    public Boolean isEqual() {
        if (currency1.getType().equals("Dollar")) {
            double currency2Amount = currency2.getAmount();
            return convertRupeeIntoDollar().equals(String.format("%.2f", currency2Amount));
        } else if (currency1.getType().equals("Rupee")) {
            double currency2Amount = currency2.getAmount();
            return convertDollarIntoRupee().equals(String.format("%.2f", currency2Amount));
        }
        return null;
    }
}