package Wallet;

import java.util.ArrayList;

import static Wallet.Currency.getDollarValueInRupee;

public class Wallet {
    Currency currency1, currency2;
    ArrayList<Currency> currencyList = new ArrayList<>();
    Currency balanceAmount = new Currency();

    public Wallet(Currency Currency1, Currency Currency2) {
        this.currency1 = Currency1;
        this.currency2 = Currency2;
    }

    public Wallet() {
        balanceAmount.setAmount(0);
        balanceAmount.setType("Rupee");
    }

    private double convertRupeeIntoDollar(Currency currency) {
        double dollarValue = getDollarValueInRupee();
        double currencyAmount = currency.getAmount();
        return Double.parseDouble(String.format("%.2f", currencyAmount / dollarValue));
    }

    private double convertDollarIntoRupee(Currency currency) {
        double dollarValue = getDollarValueInRupee();
        double currencyAmount = currency.getAmount();
        return Double.parseDouble(String.format("%.2f", currencyAmount * dollarValue));
    }

    private boolean checkForNonZeroDepositOrWithdrawValue(Currency currency) throws ZeroDepositOrWithdrawException {
        if (currency.getAmount() == 0.0)
            throw new ZeroDepositOrWithdrawException("Minimum Amount To be Deposited Or Withdrawn : 1");
        return true;
    }

    private boolean checkForSufficientBalance(double withdrawAmount) throws InSufficientBalanceException {
        if (withdrawAmount > balanceAmount.getAmount())
            throw new InSufficientBalanceException("Available Balance is Not Sufficient");
        return true;
    }

    public Boolean isEqual() {
        if (currency1.getType().equals("Dollar")) {
            double currency2Amount = currency2.getAmount();
            return convertDollarIntoRupee(currency1) == currency2Amount;
        } else if (currency1.getType().equals("Rupee")) {
            double currency2Amount = currency2.getAmount();
            return convertRupeeIntoDollar(currency1) == currency2Amount;
        }
        return null;
    }

    public double amount(String currencyType) {
        if (currencyType.equals("Rupee"))
            return balanceAmount.getAmount();
        else if (currencyType.equals("Dollar"))
            return convertRupeeIntoDollar(balanceAmount);
        return 0;
    }

    public String deposit(Currency currency) {
        try {
            if (checkForNonZeroDepositOrWithdrawValue(currency)) {
                currencyList.add(currency);
                if (currency.getType().equals("Dollar"))
                    balanceAmount.setAmount(balanceAmount.getAmount() + convertDollarIntoRupee(currency));
                else
                    balanceAmount.setAmount(balanceAmount.getAmount() + currency.getAmount());
                return currencyList.get(currencyList.size() - 1).getAmount() + " "
                        + currencyList.get(currencyList.size() - 1).getType()
                        + " is Deposited Into The Wallet";
            }
        } catch (ZeroDepositOrWithdrawException e) {
            return e.getMessage();
        }
        return "";
    }

    public String withdraw(Currency withdrawAmount) {
        try {
            if (withdrawAmount.getType().equals("Rupee")) {
                if (checkForSufficientBalance(withdrawAmount.getAmount())
                        && checkForNonZeroDepositOrWithdrawValue(withdrawAmount)) {
                    balanceAmount.setAmount(balanceAmount.getAmount() - withdrawAmount.getAmount());
                    return withdrawAmount.getAmount() + " " + withdrawAmount.getType() +
                            " is Withdrawn From The wallet";
                }
            } else if (withdrawAmount.getType().equals("Dollar")) {
                double withdrawAmountConvertedInRupee = convertDollarIntoRupee(withdrawAmount);
                if (checkForSufficientBalance(withdrawAmountConvertedInRupee)
                        && checkForNonZeroDepositOrWithdrawValue(withdrawAmount)) {
                    balanceAmount.setAmount(balanceAmount.getAmount() - withdrawAmountConvertedInRupee);
                    return withdrawAmount.getAmount() + " " + withdrawAmount.getType() +
                            " is Withdrawn From The wallet";
                }
            }
        } catch (InSufficientBalanceException | ZeroDepositOrWithdrawException e) {
            return e.getMessage();
        }
        return "";
    }
}