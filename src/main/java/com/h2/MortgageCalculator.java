package com.h2;

import java.text.DecimalFormat;

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

    public static void main(String[] args) {
        long loanAmount = Long.parseLong(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate = Float.parseFloat(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator
                .calculateMonthlyPayment();

        System.out.println(calculator.toString());
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

    /**
     * This method computes the monthly mortgage payment.
     */
    public void calculateMonthlyPayment() {
        float r = getMonthlyInterestRate();
        long P = loanAmount;
        int n = getNumberOfPayments();

        monthlyPayment = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }
}
