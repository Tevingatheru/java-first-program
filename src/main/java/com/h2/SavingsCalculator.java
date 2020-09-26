package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public float[] getCredits() {
        return credits;
    }

    public void setCredits(float[] credits) {
        this.credits = credits;
    }

    public float[] getDebits() {
        return debits;
    }

    public void setDebits(float[] debits) {
        this.debits = debits;
    }

    public static void main(String[] args) {
        final String[] creditsAsString = args[0].split(",");
        final String[] debitsAsString = args[1].split(",");

        final float[] credits = new float[creditsAsString.length];
        final float[] debits = new float[debitsAsString.length];

        for (int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for (int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        final SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

    /**
     * @return sum credits
     */
    private float sumOfCredits() {

        float sum = 0.0f;
        for(float credit: credits) {
            sum += credit;
        }
        return sum;
    }

    /**
     *
     * @return sum debits
     */
    private float sumOfDebits() {

        float sum = 0.0f;
        for(float debit: debits) {
            sum += debit;
        }
        return sum;
    }

    /**
     *
     * @param date current date
     * @return number of remaining days
     */
    private static int remainingDaysInMonth(LocalDate date) {

        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    /**
     * @return sumOfCredits minus sumOfDebits
     */
    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

}
