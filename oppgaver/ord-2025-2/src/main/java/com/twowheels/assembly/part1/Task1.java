package com.twowheels.assembly.part1;

public class Task1 {

    /* This method takes an integer number of minutes as input (e.g. 530) 
     * and converts it to a 12-hour clock format showing the hours and minutes (e.g. 8:50).
     */

    public void convertToClockTime(int totalMinutes) {

        int hour = 0; // Placeholder for hour
        int minutes = 0; // Placeholder for minutes

        // TODO: Comment in the correct line of code

        // int hour = (totalMinutes / 12) % 60; int minutes = totalMinutes / 60;
        // int hour = (totalMinutes % 60); int minutes = (totalMinutes / 60) % 12;
        // int hour = (totalMinutes / 60) % 12; int minutes = totalMinutes % 60;
        // int hour = totalMinutes / 60; int minutes = (totalMinutes / 12) % 60;

        // Convert 0 hour to 12 for 12-hour clock format
        if (hour == 0) {
            hour = 12;
        }

        System.out.println(hour + ":" + String.format("%02d", minutes));
    }

    public static void main(String[] args) {
                
        // You can write your own code here to test the method.
    }
}
