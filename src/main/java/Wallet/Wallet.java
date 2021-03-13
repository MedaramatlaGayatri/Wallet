package Wallet;

import java.util.ArrayList;

import static Wallet.Currency.getDollarValueInRupee;

public class Wallet {
    Currency currency1, currency2;
    ArrayList<Currency> currencyList = new ArrayList<>();
    double amount = 0;

    Wallet(Currency Currency1, Currency Currency2) {
        this.currency1 = Currency1;
        this.currency2 = Currency2;
    }

    public Wallet() {
    }

    private String convertRupeeIntoDollar(Currency currency) {
        double dollarValue = getDollarValueInRupee();
        double currencyAmount = currency.getAmount();
        return String.format("%.2f", currencyAmount / dollarValue);
    }

    private String convertDollarIntoRupee(Currency currency) {
        double dollarValue = getDollarValueInRupee();
        double currencyAmount = currency.getAmount();
        return String.format("%.2f", currencyAmount * dollarValue);
    }

    public Boolean isEqual() {
        if (currency1.getType().equals("Dollar")) {
            double currency2Amount = currency2.getAmount();
            return convertDollarIntoRupee(currency1).equals(String.format("%.2f", currency2Amount));
        } else if (currency1.getType().equals("Rupee")) {
            double currency2Amount = currency2.getAmount();
            return convertRupeeIntoDollar(currency1).equals(String.format("%.2f", currency2Amount));
        }
        return null;
    }

    private boolean checkForZeroDepositException(Currency currency) throws ZeroDepositException {
        if (currency.getAmount() == 0.0)
            throw new ZeroDepositException("Minimum Amount To be Deposited : 1");
        return false;
    }

    public String deposit(Currency currency) {
        try {
            if (!checkForZeroDepositException(currency)) {
                currencyList.add(currency);
                return currencyList.get(currencyList.size() - 1).getAmount() + " "
                        + currencyList.get(currencyList.size() - 1).getType()
                        + " is Deposited Into The Wallet";
            }
        } catch (ZeroDepositException e) {
            return e.getMessage();
        }
        return "";
    }

    public double amount(String currencyType) {
        amount = 0;
        if (currencyType.equals("Rupee")) {
            for (Currency currency : currencyList) {
                if (currency.getType().equals("Rupee"))
                    amount += currency.getAmount();
                else if (currency.getType().equals("Dollar"))
                    amount += Double.parseDouble(convertDollarIntoRupee(currency));
            }
            return amount;
        } else if (currencyType.equals("Dollar")) {
            for (Currency currency : currencyList) {
                if (currency.getType().equals("Dollar"))
                    amount += currency.getAmount();
                else if (currency.getType().equals("Rupee"))
                    amount += Double.parseDouble(convertRupeeIntoDollar(currency));
            }
            return amount;
        }
        return 0;
    }
}