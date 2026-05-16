package com.library.part1;

public class Task4 {

    /**
     * This class demonstrates method overloading for calculating late fees.
     * The calculateLateFee method should be overloaded to handle different scenarios:
     * 
     * 1. calculateLateFee(int daysLate) - $1.50 per day
     * 2. calculateLateFee(int daysLate, boolean isPremiumMember) - $1.50 per day, but half price for premium members
     * 
     * Comment in the correct method implementations.
     * 
     * LF: FOr Method 1, alternatives 3,4 and 5 are all correct.
     * LF: For Method 2, alternatives 1 and 4 are correct
     */

    // Method 1: Basic late fee calculation
    public double calculateLateFee(int daysLate) {
        // TODO Uncomment the correct implementation

        // return daysLate * 1.0;
        // return daysLate * 1.50;
        // return daysLate >= 0 ? daysLate * 1.50 : 0.0;
        return Math.max(0, daysLate) * 1.50;
        // return daysLate > 0 ? daysLate * 1.50 : 0.0;

        // return 0.0; // This line is only in place to make the code compile, do not remove it
    }

    // Method 2: Late fee with premium member discount
    public double calculateLateFee(int daysLate, boolean isPremiumMember) {
        // TODO Uncomment the correct implementation

        double baseFee = calculateLateFee(daysLate); return isPremiumMember ? baseFee * 0.5 : baseFee;
        // return isPremiumMember ? daysLate * 0.75 : daysLate * 1.50;
        // double fee = daysLate * 1.50; return isPremiumMember ? fee / 2 : fee;
        // if (isPremiumMember) return calculateLateFee(daysLate) * 0.5; return calculateLateFee(daysLate);
        // return daysLate * (isPremiumMember ? 0.75 : 1.50);

        // return 0.0; // Placeholder - remove after uncommenting the correct line
    }



    public static void main(String[] args) {
        Task4 task = new Task4();
        System.out.println("Basic fee (5 days): $" + task.calculateLateFee(5)); // Should be $7.50
        System.out.println("Premium member (5 days): $" + task.calculateLateFee(5, true)); // Should be $3.75
    
    }
}
