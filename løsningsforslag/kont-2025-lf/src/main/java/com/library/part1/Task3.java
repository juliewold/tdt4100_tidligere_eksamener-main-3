package com.library.part1;

public class Task3 {

    private String title;
    private boolean isAvailable;
    private int borrowCount;

    /**
     * This constructor should initialize a library item with proper encapsulation.
     * - title should not be null or empty
     * - isAvailable should be true by default
     * - borrowCount should start at 0
     * 
     * Comment in the line(s) that correctly implement the constructor.
     * 
     * @param title the title of the library item
     */
    public Task3(String title) {
        // TODO Uncomment the line(s) that correctly implement the constructor

        // this.title = title; this.isAvailable = true; this.borrowCount = 0;
        // if (title != null && !title.trim().isEmpty()) { this.title = title; this.isAvailable = true; this.borrowCount = 0; }
        // this.title = title == null ? "Unknown" : title; this.isAvailable = true; this.borrowCount = 0;
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty"); this.title = title; this.isAvailable = true; this.borrowCount = 0;
        // this.title = title.trim(); this.isAvailable = true; this.borrowCount = 0;
    }

    public static void main(String[] args) {
        
        //Task3 item2 = new Task3(""); // Should throw IllegalArgumentException
        // Task3 item3 = new Task3(null); // Should throw IllegalArgumentException
    }
}
