package com.library.part1;

public class Task2 {

    /**
     * This method should find the maximum fine amount from an array of fine values.
     * If the array is null or empty, return 0.0.
     * If all values are negative, return 0.0 (no valid fines).
     * 
     * UNCOMMENT the line that is INCORRECT according to the JavaDoc specification.
     * 
     * @param fines array of fine amounts (can contain negative values)
     * @return the maximum fine amount, or 0.0 if no valid fines exist
     * 
     * LF: All except alternative 1 are correct implementations, so uncomment line 1.
     * The question was meant to ask for the alternative that is NOT correct.
     */
    public double findMaxFine(double[] fines) {
        // TODO Uncomment the line that is INCORRECT as specified in the JavaDoc

        if (fines == null || fines.length == 0) return 0.0;

         double max = fines[0]; for (int i = 1; i < fines.length; i++) { if (fines[i] > max) max = fines[i]; } return max;
        // double max = 0.0; for (double fine : fines) { if (fine > max) max = fine; } return max;
        // double max = Double.MIN_VALUE; for (double fine : fines) { if (fine > max && fine >= 0) max = fine; } return max == Double.MIN_VALUE ? 0.0 : max;
        // double max = -1.0; for (double fine : fines) { max = Math.max(max, fine); } return Math.max(0.0, max);
        // double max = fines[0]; for (double fine : fines) { max = Math.max(max, fine); } return max < 0 ? 0.0 : max;

        // return 0.0; // Placeholder - remove after uncommenting the correct line
    }

}
