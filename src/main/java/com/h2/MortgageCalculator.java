package com.h2;

/**
 * This class facilitates the calculation of the net monthly savings
 * for an individual given their income and expenses.
 * Income is denoted as credits and expenses is denoted as debit.
 */
public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    /**
     * This method is required to compute the monthly mortgage payment.
     * @return number of payments of type {@int}
     */
    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    /**
     * This method calculates a monthly interest rate for mortgage payment.
     * @return monthly interest rate of type {@float}
     */
    private float getMonthlyInterestRate() {
        float interestRate  = (annualRate/100)/12;
        return interestRate;
    }
}
